package linkedlist.leetcode;


class ListNode {
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

public class Kreversal {

    public ListNode reverseKGroup(ListNode head, int k) {
        // 上来直接获取end节点位置
        ListNode end = getKGroupEnd(head, k);
        // 如果end节点为空代表链表长度小于k直接返回即可
        if (end == null) {
            return head;
        }
        // 定义start变量
        ListNode start = head;
        // 第一次反转
        reversal(start, end);
        // 让head指向end位置
        head = end;

        // 定义lastEnd记录上一次结束的位置(直接.next = 这次start的位置)
        ListNode lastEnd = start;

        while (lastEnd.next != null) {
            // 获取本次处理链表的起始位置
            start = lastEnd.next;
            // 获取本次处理链表的结束位置
            end = getKGroupEnd(start, k);
            if(end == null){
                return head;
            }
            // 反转链表
            reversal(start, end);
            // 当前这一段链表反转后,上一次链表结束位置还指向本次链表的start位置,但是现在start和end反转了,所以应该指向end
            lastEnd.next = end;
            // lastEnd指向本次循环结束位置
            lastEnd = start;
        }
        return head;
    }


    /**
     * 获取K获取end指针
     *
     * @param start start起始指针
     * @param k     K
     * @return 结束指针
     */
    public ListNode getKGroupEnd(ListNode start, int k) {
        while (--k > 0 && start != null) {
            start = start.next;
        }
        return start;
    }

    public void reversal(ListNode start, ListNode end) {
        // 让end指向自己下一个节点
        end = end.next;
        // 定义pre
        ListNode pre = null;
        // 定义当前节点变量
        ListNode cur = start;
        // 定义下一个节点元素
        ListNode next;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        ListNode end = listNode.next.next;

        Kreversal kreversal = new Kreversal();
        kreversal.reversal(listNode, end);
        listNode = end;
        System.out.println(listNode);
    }
}

