/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	//删除链表中所有值为参数的元素
    public ListNode removeElements(ListNode n, int val) {
        if(n == null)   return null;
        n.next = removeElements(n.next, val);
        if(n.val == val)    return n.next;
        return n;
    }
}