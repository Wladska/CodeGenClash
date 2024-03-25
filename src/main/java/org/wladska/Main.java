package org.wladska;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}

	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		// Dummy node to help easily return the head of the merged list
		ListNode prehead = new ListNode(-1);

		ListNode prev = prehead;
		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				prev.next = list1;
				list1 = list1.next;
			} else {
				prev.next = list2;
				list2 = list2.next;
			}
			prev = prev.next;
		}

		// At least one of list1 and list2 can still have nodes at this point, so connect
		// the non-null list to the end of the merged list.
		prev.next = (list1 == null) ? list2 : list1;

		return prehead.next; // Return the head of the merged list
	}
}
