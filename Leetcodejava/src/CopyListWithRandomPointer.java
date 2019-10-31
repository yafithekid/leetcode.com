public class CopyListWithRandomPointer {
    public static void main(String[] args){
        new CopyListWithRandomPointer();
    }

    public CopyListWithRandomPointer(){
        Node[] node = new Node[3];
        node[1] = new Node();

        node[2] = new Node();
        node[1].val = 1;
        node[1].next =  node[2];
        node[1].random = node[2];

        node[2].val = 2;
        node[2].next = null;
        node[2].random = node[2];

        new Solution().copyRandomList(node[1]);
    }
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    class NodeCopy extends Node {
        public Node copy;
        public Node original;
        public NodeCopy next;

    }

    class Solution {
        public Node copyRandomList(Node head) {
            Node chead = head;

            NodeCopy nodeCopyHead = new NodeCopy();
            nodeCopyHead.original = head;
            nodeCopyHead.copy = new Node();
            nodeCopyHead.copy.val = nodeCopyHead.original.val;

            NodeCopy nodeCopyCurrent = nodeCopyHead;

            System.out.println(chead.val);
            while (true){
                chead = chead.next;
                if (chead == null) break;

                NodeCopy nodeCopy = new NodeCopy();
                nodeCopy.original = chead;
                nodeCopy.copy = new Node();
                nodeCopy.copy.val = nodeCopy.original.val;
                nodeCopyCurrent.next = nodeCopy;
                nodeCopyCurrent = nodeCopy;
            }
            nodeCopyCurrent = nodeCopyHead;
            while (true){
                nodeCopyCurrent.copy.next = nodeCopyCurrent.next.copy;
//                nodeCopyCurrent.
            }
        }
    }
}
