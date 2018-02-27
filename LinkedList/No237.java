/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	/*
	*删除链表中的指定元素
	*/
    public void deleteNode(ListNode n) {
        if(n == null || n.next == null) return;
        ListNode rt = n.next;
        n.val = rt.val;
        n.next = rt.next;
    }
}