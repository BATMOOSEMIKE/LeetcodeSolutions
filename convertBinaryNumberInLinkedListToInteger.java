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
    public int getDecimalValue(ListNode head) {
        ListNode reversed = reverse(head);

        int digit = 1;
        int count = 0;

        while(reversed != null){
            count += digit * reversed.val;
            digit *= 2;
            reversed = reversed.next;
        }

        return count;
    }

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) {
            return head;
        }
        ListNode temp = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
}
