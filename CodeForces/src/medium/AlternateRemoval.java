package medium;

import util.ListNode;

public class AlternateRemoval {
	public int lastNumber(int n) {
		ListNode root = new ListNode(n);
		ListNode head = root;
		for(int i=n-1;i>0;i--) {
			head = new ListNode(i, head);
		}
		root.next=head;		
		root = head;
		while(root.size()>1) {
			root.next = root.next.next;
			root = root.next;
		}
		
		return root.val;
	}
	
	public static void main(String[] args) {
		for(int i=1;i<=2000;i++) {
			assert new AlternateRemoval().lastNumber(i)==(int)(
					1+2*(i-Math.pow(2,Math.floor(Math.log(i)/Math.log(2)))));
		}
	}
}
