package medium;

import util.ListNode;

public class Solution24 {
	
	public static void main(String[] args) {
		new Solution24().swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
	}
	
	public ListNode swapPairs(ListNode head) {
		ListNode temp = new ListNode(0, head);
		while(temp.next!=null && temp.next.next!=null) {
			ListNode i = temp.next;
			temp.next = temp.next.next;
			i.next = temp.next.next;
			if(i==head) {
				head = temp.next;
			}
			temp.next.next=i;
			temp = temp.next.next;
		}
		return head;
	}
}
