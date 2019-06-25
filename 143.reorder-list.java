/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
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
    static int len;
    static ListNode tail;
    static ListNode mid;

    public void reorderList(ListNode head) {
       if(head == null || head.next == null) return;

       len = 0;
       tail = null;
       mid = null;

       recur(head, 0);
       
        ListNode node = head, nh = head.next, nt = tail.next;
        node.next = tail;
        node = tail;
        
        for(int i = 0; i < len / 2 - 1; i ++){
            ListNode tmp = nh.next;
            node.next = nh;
            nh = tmp;
            node = node.next;

            tmp = nt.next;
            node.next = nt;
            nt = tmp;
            node = node.next;
        }

        if(mid != null){
            node.next = mid;
            node = node.next;
        }
        node.next = null;
    }

    ListNode recur(ListNode node, int i){
        len ++;
        if(node.next == null){
            tail = node;
        }else{
            ListNode nxt = recur(node.next, i + 1);
            if((len % 2 == 1) && (i == len / 2)) mid = node;
            if(i >= len / 2){
                nxt.next = node;
            }
        }
        return node;
    }
}

