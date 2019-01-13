/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode h) {
        if(h == null || h.next == null) return h;
        ListNode dummy = new ListNode(-1);
        dummy.next = h;
        
        ListNode p= dummy;
        while(h != null){
            ListNode cur = h;
            while(h != null && h.next != null && h.val == h.next.val){
                h = h.next;
            }
            if(cur==h){
                p = h;
                h = h.next;
            }else{
                //h is last dup
                h = h.next;
                p.next = h;   
            }
        }
        return dummy.next;
    }
}
