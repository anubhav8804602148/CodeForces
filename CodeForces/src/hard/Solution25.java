package hard;

import util.ListNode;

public class Solution25 {
	
	public ListNode reverseK(ListNode root,int k) {
		ListNode head = new ListNode(root.val, root.next);
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
	
	public int sizeOfList(ListNode node) {
		int size=0;
		while(node!=null) {
			node = node.next;
			size++;
		}
		return size;
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
		
		ListNode curr = head;
		ListNode prev=null, next=null;
		while(curr!=null) {
			for(int i=0;i<k && curr!=null;i++) {
				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;				
			}
		}
		
        return prev;
    }
	public static void main(String[] args) {
		System.out.println(new Solution25().sizeOfList(new ListNode(9, new ListNode())));
	}
}
