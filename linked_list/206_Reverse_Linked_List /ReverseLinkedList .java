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
    1->2->3->4->5
    */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head !=null){
            ListNode curr = head;
            head = head.next;
            curr.next = prev;
            prev = curr;
        }
        return prev;
    }
}