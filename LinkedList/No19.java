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
        sub(dummy, n);
        return dummy.next;
    }
    
    //return index from right
    private int sub(ListNode node,int target){
        if(node.next == null) return 1;
        //get index from right
        int idxFromRight = sub(node.next, target) + 1;
        //remove if next is target
        if(idxFromRight - 1 == target){
            ListNode right = node.next;
            node.next = right.next;
            right = null;
        }   
        return idxFromRight;
    }
}