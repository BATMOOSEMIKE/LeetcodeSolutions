//O(n) runtime, O(1) space

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode og = dummy;
        while(dummy != null){
            while(dummy.next != null && dummy.next.val == val){
                dummy.next = dummy.next.next;
            }
            dummy = dummy.next;
        }

        return og.next;
    }
}
