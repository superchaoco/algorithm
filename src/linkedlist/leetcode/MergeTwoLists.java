package linkedlist.leetcode;

public class MergeTwoLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2) {
        // 边界处理
        if (listNode1 == null || listNode2 == null) {
            return listNode1 == null ? listNode2 : listNode1;
        }
        // 先确定两个链表谁作为头部
        ListNode head = listNode1.val < listNode2.val ? listNode1 : listNode2;

        // 创建两个当前需要比较的节点
        // cur1代表头部链表,cur2代表不是头部链表的那条链表,让头部链表的下一个节点和第二个链表的第一个节点值作比较
        ListNode cur1 = head.next;
        ListNode cur2 = head == listNode1 ? listNode2 : listNode1;

        // 定义一个临时变量指向head
        ListNode temp = head;
        while (cur1 != null && cur2 != null) {
            // 比较两个值大小
            if (cur1.val < cur2.val) {
                // 如果cur1小,那就把cur1设置成下一个节点
                temp.next = cur1;
                // cur1这个节点比完了让cur1的下一个节点和cur2比
                cur1 = cur1.next;
            } else {
                // 如果cur2小,那就把cur2设置成下一个节点
                temp.next = cur2;
                // cur2这个节点比完了让cur2的下一个节点和cur1比
                cur2 = cur2.next;
            }

            // 让temp指针指向下一个节点,继续锁定下一个节点的值
            temp = temp.next;
        }
        // 循环结束后,如果1,2链表长短不一会导致长链表丢失长度,所需需要指定一下
        temp.next = cur1 == null ? cur2 : cur1;

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(5);
        listNode.next.next.next = new ListNode(9);

        ListNode listNode2 = new ListNode(2);
        listNode2.next = new ListNode(4);
        listNode2.next.next = new ListNode(6);

    }
}
