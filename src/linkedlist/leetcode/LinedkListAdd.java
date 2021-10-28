package linkedlist.leetcode;

import java.util.Arrays;

public class LinedkListAdd {
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

    public ListNode addTwoNumbers(ListNode listNode1, ListNode listNode2) {
        // 先判断边界
        if (listNode1 == null || listNode2 == null) {
            return listNode1 == null ? listNode2 : listNode1;
        }
        // 锁定长短链表
        ListNode l = getListNodeSize(listNode1) > getListNodeSize(listNode2) ? listNode1 : listNode2;
        ListNode s = l == listNode1 ? listNode2 : listNode1;
        // 创建返回节点
        ListNode resultListNode = l;
        // 创建跟踪节点 == > 跟踪长链表,因为长链表遍历结束肯定指向NULL
        // 所以如果需要补一位进位数,就得知道尾节点是什么
        ListNode trackNode = l;

        // 定义每次求和的sum
        int sum;
        // 定义进位数
        int temp = 0;

        // 遍历短链表 == > 两两求和 + 进位数
        while (s != null) {
            // sum  = 长链表值 + 短链表值 + 进位数
            sum = l.val + s.val + temp;
            // 当前节点位置的值就是sum的余数
            l.val = sum % 10;
            // 进位数被用了,重新赋值进位数
            temp = sum / 10;
            // 跟踪节点,跟踪长链表指向next节点前的节点
            trackNode = l;
            // 长短链表往下指继续遍历
            s = s.next;
            l = l.next;
        }

        // 短链表遍历结束,开始遍历只有长链表元素的情况
        while (l != null) {
            // 这个节点的和 = 当前节点值 + 进位数
            sum = l.val + temp;
            // 这个节点值应该是10的余数
            l.val = sum % 10;
            // 进位数重新赋值
            temp = sum / 10;
            // 跟踪节点,跟踪长链表指向next节点前的节点
            trackNode = l;
            // 长链表往下指继续遍历
            l = l.next;
        }

        // 长短链表全部遍历结束,如果进位数还剩1应该新添加节点
        if (temp != 0) {
            // 如果没有trackNode, 尾部指针就找不到了
            trackNode.next = new ListNode(1);
        }

        return resultListNode;
    }


    public static int getListNodeSize(ListNode listNode) {
        int resultInt = 0;
        while (listNode != null) {
            resultInt++;
            listNode = listNode.next;
        }
        return resultInt;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(7);
//        listNode.next.next = new ListNode(9);
//        listNode.next.next.next = new ListNode(9);
//        listNode.next.next.next.next = new ListNode(9);
//        listNode.next.next.next.next.next = new ListNode(9);
//        listNode.next.next.next.next.next.next = new ListNode(9);

        ListNode listNode2 = new ListNode(9);
        listNode2.next = new ListNode(2);
//        listNode2.next.next = new ListNode(9);
//        listNode2.next.next.next = new ListNode(9);

        LinedkListAdd linedkListAdd = new LinedkListAdd();
        ListNode listNode1 = linedkListAdd.addTwoNumbers(listNode, listNode2);
        System.out.println(listNode1);
    }
}























