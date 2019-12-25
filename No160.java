/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

//简单解法，时间 O(m + n), 空间 O(n)    
private Set<ListNode> set = new HashSet<>();
    
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        while(a!=null){
            set.add(a);
            a = a.next;
        }
        while(b != null){
            if(set.contains(b)) return b;
            b = b.next;
        }
        return null;
    }

}

//机智的解法, 时间 O(m + n), 空间 O(1)
//难点在于不确定两个链表的长度，但是它们的长度和是确定的。
//所以在一次循环中同时进行 a -> b, b -> a
//如果两个链表相交，那么某一时刻 a == b，否则 a == b == null
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)  return null;
        ListNode a = headA;
        ListNode b = headB;
        while(a != b){
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
}