package linkedlist.own;

public class Node {
    private Integer value;
    private Node pre;
    private Node next;

    public Node(Integer value) {
        this.value = value;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * 思路就是把现在的head的上下节点调换位置
     *
     * @param head 单向链表
     * @return 转换后的链表
     */
    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        while (head != null) {
            // 获取上一个节点
            Node next = head.getNext();
            // 设置下一个节点的位置为上一个节点
            head.next = pre;
            // 因为head下一个节点的上一个节点(pre)为null 所以需要提前设置
            // 实际上下一个节点的上一个节点不就是自己吗!!!
            pre = head;
            // 遍历下一个节点
            head = next;
        }
        return pre;
    }
}

class TestMain {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.setNext(new Node(2));
        head.getNext().setNext(new Node(3));
        head = Node.reverseLinkedList(head);
        while (head != null) {
            System.out.println(head.getValue());
            head = head.getNext();
        }
    }
}