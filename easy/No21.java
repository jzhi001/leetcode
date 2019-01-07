/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)    return null;
        if(l1 == null || l2 == null)    return l1 == null ? l2 : l1;
        ListNode result = l1;
        ListNode before = null;
        ListNode nextOne = l2;
        ListNode sorted = l1;
        
        while(l2 != null){
            nextOne = nextOne.next;
            if(l2.val < sorted.val){
                if(before == null){
                    result = l2;
                    l2.next = l1;
                    before = l2;
                }else{
                    before.next = l2;
                    l2.next = l1;
                    before = l2;
                }
            }else{
                ListNode pos = sorted;
                while(pos.next != null){
                    if(l2.val > pos.next.val)
                        pos = pos.next;
                    else
                        break;
                }
                ListNode temp = pos.next;
                pos.next = l2;
                l2.next = temp;
                sorted = l2;
                before = pos;
            }
            l2 = nextOne;
        }
        
        return result;
    }
}

//better solution
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        
        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }