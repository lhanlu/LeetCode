/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 
 * 
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyhead = new ListNode(0);
        ListNode curr = dummyhead;
        int add = 0;
        while(l1 != null || l2 != null){
            int l1v = (l1 != null)? l1.val: 0;
            int l2v = (l2 != null)? l2.val: 0;
            int sum = l1v + l2v + add;
            curr.next = new ListNode(sum%10);
            if(add > 0) add--;
            if(sum >= 10) add++;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            curr = curr.next;
        }
        if(add > 0) curr.next = new ListNode(add);
        return dummyhead.next;
    }
}