package util;

public class CListNode {
	public int val;
	public CListNode next;

	public CListNode() {
	}

	public CListNode(int val) {
		this.val = val;
	}

	public CListNode(int val, CListNode next) {
		this.val = val;
		this.next = next;
	}
	
	public void printListNode() {
		StringBuilder buffer = new StringBuilder(String.valueOf(val));
		CListNode temp = next;
		while(temp!=null) {
			buffer.append(","+temp.val);
			temp = temp.next;
		}
		System.out.println(buffer.toString());
	}
}
