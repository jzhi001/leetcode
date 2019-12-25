/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        /*iter lists
        * get lowest
        * merge it
        */
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode current = dummy;
        
        int len = lists.length;
        
        while(hasElem(lists)){
            int lowestIdx = lowestIdx(lists);
            current.next = lists[lowestIdx];
            current = lists[lowestIdx];
            lists[lowestIdx] = lists[lowestIdx].next;
        }
        return dummy.next;
    }
    
    private boolean hasElem(ListNode[] lists){
        for(int i=0; i<lists.length; i++){
            if(lists[i] != null) return true;
        }
        return false;
    }
    
    private int lowestIdx(ListNode[] lists){
        int result = -1;
        for(int i=0; i<lists.length;i++){
            if(lists[i] == null) continue;
            if(result == -1 || lists[i].val < lists[result].val) result = i;
        }
        return result;
    }
}