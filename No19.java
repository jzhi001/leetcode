/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        
        r(dummy, n);
        
        return dummy.next;
    }
    
    //let the next one told me which position i am
    private int r(ListNode node, int n){
        if(node == null) return 0;
        int pos = r(node.next, n) + 1;
        if(pos != n + 1) return pos;
        ListNode rm = node.next;
        node.next = rm.next;
        rm.next = null;
        return pos; 
    }
}
