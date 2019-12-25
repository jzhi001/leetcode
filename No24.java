/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        
        ListNode pre = dummy;
        ListNode a = null;
        ListNode b = null;
        
        while(pre.next != null && pre.next.next != null){
            //to swap
            a = pre.next;
            b = a.next;
            //swap
            pre.next = b;
            a.next = b.next;
            b.next = a;
            //state change
            pre = pre.next.next;
        }
        
        return dummy.next;
    }
}