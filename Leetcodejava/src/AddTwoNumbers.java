import java.util.List;

public class AddTwoNumbers {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    class Solution {
        public ListNode addTwoNumbers(ListNode l1,ListNode l2){
            return addTwoNumbers(l1,l2,0);
        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2,int carry) {
            if (l1 == null && l2 == null){
                if (carry == 1){
                    return new ListNode(carry);
                } else {
                    return null;
                }
            }
            ListNode listNode = new ListNode(0);
            if (l1 == null){
                listNode.val = l2.val + carry;
                l2 = l2.next;
            } else if (l2 == null){
                listNode.val = l1.val + carry;
                l1 = l1.next;
            } else {
                listNode.val = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }
            listNode.next = addTwoNumbers(l1,l2,listNode.val / 10);
            listNode.val %= 10;
            return listNode;
        }
    }

}
