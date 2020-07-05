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
    public ListNode middleNode(ListNode head) {
        int length = length(head);
        for(int i = 0; i < length/2; i++){
            head = head.next;
        }
        return head;
    }

    public int length(ListNode head) {
        int count = 0;
        while(head != null){
            head = head.next;
            count++;
        }
        return count;
    }
}
