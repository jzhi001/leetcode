/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode result = null;
        ListNode now = null;
        
        boolean over = false;
        
        while(true){
            if(l1 == null && l2 == null)  break;
            int val = over ? 1 : 0;
            if(l1 != null)  val += l1.val;
            if(l2 != null)  val += l2.val;
            
            if(val >= 10){
                 val -= 10;
                over = true;
            }else{
                over = false;
            }
               
            ListNode temp = new ListNode(val);
            
            if(result == null)
                result = temp;
            else
                now.next = temp;
            now = temp;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(over)
            now.next = new ListNode(1);
        
        return result;
    }
}