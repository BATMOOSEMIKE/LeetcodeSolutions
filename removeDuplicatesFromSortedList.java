//O(n) runtime, O(n) space, didn't realize list was sorted, can just compare adjacent ones instead
//this solution will work for all lists

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
    public ListNode deleteDuplicates(ListNode head) {
        HashSet<Integer> seen = new HashSet<Integer>();

        ListNode dummy = new ListNode(0, head);

        while(head != null){
            seen.add(head.val);
            if(head.next != null && seen.contains(head.next.val)){
                head.next = head.next.next;
            }
            else{
                head = head.next;
            }
        }

        return dummy.next;
    }
}
