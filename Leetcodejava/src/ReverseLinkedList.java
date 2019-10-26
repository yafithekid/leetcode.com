public class ReverseLinkedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        public String toString(){
            String x = val + "->";
            if (next == null){
                return x;
            } else {
                return x + next.toString();
            }
        }

    }

    class Solution {
        private ListNode last;
        public Solution(){
            last = null;
        }

        public ListNode reverseList(ListNode head) {
            return rec(head);
        }

        public ListNode rec(ListNode head){
            if (head == null || head.next == null){
                this.last = head;
                return head;
            }
            ListNode reversed = rec(head.next);
            last.next = head;
            last = head;
            head.next = null;
            return reversed;
        }
    }

    ReverseLinkedList(){
        ListNode[] listNodes = new ListNode[5];
        listNodes[0] = new ListNode(1);
        listNodes[1] = new ListNode(2);
        listNodes[2] = new ListNode(3);

        listNodes[0].next = listNodes[1];
        listNodes[1].next = listNodes[2];
        System.out.println(listNodes[0]);
        ListNode listNode = new Solution().reverseList(listNodes[0]);
        System.out.println(listNode);
    }

    public static void main(String[] args){
        new ReverseLinkedList();
    }
}
