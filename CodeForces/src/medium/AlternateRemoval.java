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
		int val=1;
		for(int i=1;i<=5000;i++) {
			System.out.println(i+"\t"+val);
			if(val==i) val=1;
			else val +=2;
		}
	}
}
