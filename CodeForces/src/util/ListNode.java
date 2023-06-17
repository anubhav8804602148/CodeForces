package util;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
	

	public ListNode reverseK(int k) {
		ListNode head = new ListNode(val, next);
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;
		for(int i=0;i<k && curr!=null;i++) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public int size() {
		int size = 1;
		for(ListNode temp=this.next;temp!=this && temp!=null;temp=temp.next) {
			size++;
		}
		return size;
	}
	
	public ListNode reverse() {
		ListNode head = new ListNode(val, next);
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public void printListNode() {
		StringBuffer buffer = new StringBuffer(String.valueOf(val));
		ListNode temp = next;
		while(temp!=null) {
			buffer.append(","+temp.val);
			temp = temp.next;
			if(temp==next) break;
		}
		System.out.println(buffer.toString().substring(0,buffer.lastIndexOf(",")));
	}
}
