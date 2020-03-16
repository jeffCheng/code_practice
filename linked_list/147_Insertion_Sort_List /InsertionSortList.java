/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        ListNode curr = head;
        dummy.next = curr;
        
        while(curr.next!= null){
            if(curr.val< curr.next.val) curr = curr.next;
            else{
                ListNode temp = curr.next;
                ListNode start =dummy;
                curr.next = curr.next.next;
                while(start.next.val< temp.val) start = start.next;
                temp.next = start.next;
                start.next = temp;
            }
        }
        return dummy.next;
    }
}