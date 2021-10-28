package linkedlist.others;
// 测试链接：https://leetcode.com/problems/reverse-nodes-in-k-group/
public class Code04_ReverseNodesInKGroup {

	public static void main(String[] args) {
		ListNode listNode = new ListNode();
		listNode.val = 1;
		listNode.next = new ListNode();
		listNode.next.val = 2;
		listNode.next.next = new ListNode();
		listNode.next.next.val = 3;
		listNode.next.next.next = new ListNode();
		listNode.next.next.next.val = 4;
		listNode.next.next.next.next = new ListNode();
		listNode.next.next.next.next.val = 5;
		listNode.next.next.next.next.next = new ListNode();
		listNode.next.next.next.next.next.val = 6;
		ListNode listNode1 = reverseKGroup(listNode, 3);
		while (listNode1 != null){
			System.out.println(listNode1.val);
			listNode1 = listNode1.next;
		}
	}


	// 不要提交这个类
	public static class ListNode {
		public int val;
		public ListNode next;
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode start = head;
		ListNode end = getKGroupEnd(start, k);
		if (end == null) {
			return head;
		}
		// 第一组凑齐了！
		head = end;
		reverse(start, end);
		// 上一组的结尾节点
		ListNode lastEnd = start;
		while (lastEnd.next != null) {
			start = lastEnd.next;
			end = getKGroupEnd(start, k);
			if (end == null) {
				return head;
			}
			reverse(start, end);
			lastEnd.next = end;
			lastEnd = start;
		}
		return head;
	}

	public static ListNode getKGroupEnd(ListNode start, int k) {
		while (--k != 0 && start != null) {
			start = start.next;
		}
		return start;
	}

	public static void reverse(ListNode start, ListNode end) {
		end = end.next;
		ListNode pre = null;
		ListNode cur = start;
		ListNode next = null;
		while (cur != end) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		start.next = end;
	}

}