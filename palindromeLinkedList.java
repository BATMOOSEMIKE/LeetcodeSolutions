//O(n) runtime, with O(n) space because we iterate through entire list and make a stack

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
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> elems = new Stack<Integer>();
        ListNode dummy = new ListNode(0, head);
        ListNode dummy2 = new ListNode(0, head);
        while(dummy.next != null){
            dummy = dummy.next;
            elems.push(dummy.val);
        }
        while(dummy2.next != null){
            dummy2 = dummy2.next;
            if(dummy2.val != elems.pop()){
                return false;
            }
        }

        return true;

    }
}
