import java.util.List;

public class MergeTwoSortedLists {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null){
                return null;
            }

            boolean useL1 = true;
            if (l1 == null){
                useL1 = false;
            } else if (l2 != null && l1.val > l2.val){
                useL1 = false;
            }
            ListNode listNode = new ListNode(0);
            if (useL1){
                listNode.val = l1.val;
                listNode.next = mergeTwoLists(l1.next,l2);
            } else {
                listNode.val = l2.val;
                listNode.next = mergeTwoLists(l1,l2.next);
            }
            return listNode;
        }
    }
}
