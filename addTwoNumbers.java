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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return addTwoHelper(l1, l2, 0);
    }

    public ListNode addTwoHelper(ListNode l1, ListNode l2, int carry){
        //base case
        if(l1 == null && l2 == null && carry == 0){
            return null;
        }
        //one more digit of overflow
        else if(l1 == null && l2 == null){
            return new ListNode(1, null);
        }
        //only l2 left
        else if(l1 == null){
            int sum = l2.val + carry;
            return new ListNode(sum%10, addTwoHelper(null, l2.next, sum/10));

        }
        //only l1 left
        else if(l2 == null){
            int sum = l1.val + carry;
            return new ListNode(sum%10, addTwoHelper(l1.next, null, sum/10));
        }
        //regular case, adding two digits
        else {
            int sum = l1.val + l2.val + carry;
            return new ListNode(sum%10, addTwoHelper(l1.next, l2.next, sum/10));
        }
    }
}
