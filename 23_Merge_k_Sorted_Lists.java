/* 
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }

        return mergeAll(lists);
    }

    private ListNode mergeTwo(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 == null)? l2: l1;
        return dummy.next;
    }

    private ListNode mergeAll(ListNode[] lists){
        if(lists.length == 1) return lists[0];
        int size = 0;
        if(lists.length%2 == 1) size++;
        size += lists.length/2;
        ListNode[] newList = new ListNode[size];
        for(int j = 0, i = 1; j < size && i < lists.length; j++, i++){
            newList[j] = mergeTwo(lists[i-1], lists[i]);
            i++;
        }
        if(lists.length%2 == 1) newList[size-1] = lists[length-1];
        return mergeAll(newList);

    }
}