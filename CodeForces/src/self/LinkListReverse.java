package self;

import util.ListNode;

public class LinkListReverse {
	public static void main(String[] args) {
		new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))).reverseK(3).printListNode();
	}
}
