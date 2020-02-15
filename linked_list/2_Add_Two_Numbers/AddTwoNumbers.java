
public class AddTwoNumbers {

	public static void main(String[] args) {
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// null problem
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}

		int carry = 0;
		ListNode head = new ListNode(0);
		ListNode l3 = head;
		while (l1 != null || l2 != null) {
			if (l1 != null) {
				carry += l1.val;
				l1 = l1.next;
			}

			if (l2 != null) {
				carry += l2.val;
				l2 = l2.next;
			}
			l3.next = new ListNode(carry % 10);
			carry = carry / 10;
			l3 = l3.next;
			if (carry == 1)
				l3.next = new ListNode(1);
			return head.next;
		}
		return l3;
	}
	
	
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode newHead = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p3 = newHead;
        
        while(p1!= null || p2!= null) {
        		if(p1 != null) {
        			carry += p1.val;
        			p1 = p1.next;
        		}
        		
        		if(p2 != null) {
        			carry += p2.val;
        			p2 = p2.next;
        		}
        		
        		p3.next = new ListNode(carry%10);
        		p3.next = p3;
        		carry/=10;
        }
        
        if(carry == 1) {
        		p3.next = new ListNode(1);
        }
    		return newHead.next;
    }
	
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode node = dummy;
            //ListNode n1 = l1;
            //ListNode n2 = l2;
            int carry = 0;
            while(l1!=null || l2!=null){
                int n1 = (l1 !=null)? l1.val:0;
                int n2 = (l2 != null)? l2.val:0;
                int sum = n1 + n2 + carry;
                node.next = new ListNode(sum%10);
                node = node.next;
                carry = sum/10;
                if(l1!=null) l1 = l1.next;
                if(l2 != null) l2 = l2.next;
            }
            if(carry != 0) node.next = new ListNode(carry);
            return dummy.next;
        }
    }
}
