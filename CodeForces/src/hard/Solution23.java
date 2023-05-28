package hard;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import util.ListNode;

public class Solution23 {
	public static void main(String[] args) {
		new Solution23()
				.mergeKLists(new ListNode[] { new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))),
						new ListNode(-1, new ListNode(2, new ListNode(-3, new ListNode(4)))),
						new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))) });
	}

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode head = new ListNode();
		ListNode temp = head;
		List<ListNode> allList = Arrays.asList(lists);

		while (!allList.isEmpty()) {
			allList = allList.stream().filter(ele -> ele != null).collect(Collectors.toList());
			if (allList.isEmpty())
				break;
			int i = 0;
			int minInd = 0;
			int min = allList.get(0).val;
			for (ListNode node : allList) {
				if (node.val < min) {
					minInd = i;
					min = node.val;
				}
				i++;
			}
			ListNode minNode = allList.get(minInd);
			temp.next = new ListNode(minNode.val);
			temp = temp.next;
			if (minNode.next != null) {
				minNode.val = minNode.next.val;
				minNode.next = minNode.next.next;
			} else {
				allList.remove(minInd);
			}
		}
		return head.next;
	}
}