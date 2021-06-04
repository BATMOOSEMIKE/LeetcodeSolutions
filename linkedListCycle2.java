//Two pointer Solution
//VERY IMPORTANT: This question is kinda weird, numbers can repeat
//so I checked for equality between the nodes instead of if their vals are equal

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        //first detect if we have a cycle
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            //now we know there is a cycle
            if(fast == slow){
                slow = head;
                 while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;





    }
}
