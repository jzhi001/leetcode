/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    static class Tuple{
        ListNode beforeM;
        ListNode afterN;
        ListNode oldTail;
        ListNode oldHead;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(n == m) return head;
        Tuple tuple = new Tuple();
        recur(head, 1, m, n, tuple);
        if(m > 1)
            tuple.beforeM.next = tuple.oldTail;
        if(tuple.afterN == null){
            tuple.oldHead.next = null;
        }else{
            tuple.oldHead.next = tuple.afterN;
        }
        if(m == 1) return tuple.oldTail;
        else return head;
    }

    ListNode recur(ListNode node, int i, int m, int n, Tuple tuple){
        if(i == m - 1) tuple.beforeM = node;
        else if(i == m) tuple.oldHead = node;
        else if(i == n) tuple.oldTail = node;
        else if(i == n + 1) tuple.afterN = node;

        if(node.next == null) return node;

        ListNode rt = recur(node.next, i + 1, m, n, tuple);
        
        if(i >= m && i < n) rt.next = node;
        return node;
    }
}

