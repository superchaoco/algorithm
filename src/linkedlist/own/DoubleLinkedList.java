package linkedlist.own;

public class DoubleLinkedList {
    /**
     * 定义一个单向链表结构
     *
     * @param <T> 泛型值
     */
    public static class Node<T> {
        /**
         * 定义上一个节点指针
         */
        private Node<T> last;

        /**
         * 定义下一个节点的指针
         */
        private Node<T> next;

        /**
         * 定义值
         */
        private T val;

        public Node(T val) {
            this.val = val;
        }
    }

    public static class MyDoubleQueue<T> {
        /**
         * 定义头指针
         */
        private Node<T> head;

        /**
         * 定义尾指针
         */
        private Node<T> tail;

        /**
         * 定义双向队列大小
         */
        private int size;

        /**
         * 判断当前队列是否为空
         *
         * @return true = isEmpty, false = isNotEmpty
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * 从头部新增
         *
         * @param t t
         */
        public void pushHead(T t) {
            // 创建一个新的节点
            Node<T> cur = new Node<>(t);
            if (size == 0) {
                // 如果是第一个元素头尾都 = 当前新增的节点
                head = cur;
                tail = cur;
            } else {
                // 不是第一个元素,首先把新加入的节点和head连上(头部添加,所以cur是head的上个元素)
                cur.next = head;
                // 来了新元素后当前head的上个元素就从NULL变成了cur
                head.last = cur;
                // 因为有了新节点,所以head指向新的节点cur
                head = cur;
            }
            // 添加后队列长度+1
            size++;
        }

        /**
         * 从尾部新增
         *
         * @param t t
         */
        public void pushTail(T t) {
            // 创建一个新的节点
            Node<T> cur = new Node<>(t);
            if (size == 0) {
                // 如果是第一个元素头尾都 = 当前新增的节点
                head = cur;
                tail = cur;
            } else {
                // 不是第一个元素,首先把新加入的节点和tail连上(尾添加,所以cur是tail的下个元素)
                tail.next = cur;
                // 因为tail的下一个元素是cur,所以cur的上一个元素就是tail
                cur.last = tail;
                // 因为尾部有了新元素所以tail应该指向cur
                tail = cur;
            }
            // 添加后队列长度+1
            size++;
        }

        /**
         * 从头部获取数据
         *
         * @return t
         */
        public T pollHead() {
            // 定义返回值
            T result;
            // 如果head为空直接返回
            if (head == null) {
                return null;
            }

            result = head.val;
            // 如果head = tail 证明将要被拿走的元素是最后一个元素
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                // 不是最后一个节点,head变成了head的下一个元素
                head = head.next;
                // head的last设置为空
                head.last = null;
            }
            // size -1
            size--;
            return result;
        }

        /**
         * 从尾部
         *
         * @return t
         */
        public T pollTail() {
            // 定义返回值
            T result;
            // 如果尾部为空直接返回
            if (tail == null) {
                return null;
            }

            result = tail.val;
            // 如果head = tail 证明将要被拿走的元素是最后一个元素
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                // 不是最后一个节点,tail变成了tail的上一个节点
                tail = tail.last;
                // head的last设置为空
                head.next = null;
            }
            // size -1
            size--;
            return result;
        }

        public static void main(String[] args) {
            MyDoubleQueue<String> doubleLinkedList = new MyDoubleQueue<>();
            // 从尾部添加  4 <-- 3 <-- 2 <--1
            doubleLinkedList.pushTail("1");
            doubleLinkedList.pushTail("2");
            doubleLinkedList.pushTail("3");
            doubleLinkedList.pushTail("4");

            // 从头部添加 4 <-- 3 <-- 2 <--1 <-- 5 <-- 6 <-- 7 <-- 8
            doubleLinkedList.pushHead("5");
            doubleLinkedList.pushHead("6");
            doubleLinkedList.pushHead("7");
            doubleLinkedList.pushHead("8");

            while (!doubleLinkedList.isEmpty()){
                System.out.println(doubleLinkedList.pollHead());
            }

        }
    }
}
