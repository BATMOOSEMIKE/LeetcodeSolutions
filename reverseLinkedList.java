/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode currentNode;

        if(head == null || head.next == null){
            return head;
        }
        else{
            currentNode = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return currentNode;
        }
    }
}
