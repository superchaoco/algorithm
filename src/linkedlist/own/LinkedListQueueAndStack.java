package linkedlist.own;

/**
 * @Author 王超
 * @Version V1.0.0
 * @Date 2021/10/26 14:29
 */
public class LinkedListQueueAndStack {

    /**
     * 定义一个单向链表结构
     *
     * @param <T> 泛型值
     */
    public static class Node<T> {
        private Node<T> next;
        private T val;

        public Node(T val) {
            this.val = val;
        }
    }

    /**
     * 自定义队列
     *
     * @param <T> 泛型
     */
    public static class MyQueue<T> {
        /**
         * 定义头部指针
         */
        private Node<T> head;

        /**
         * 定义尾部指针
         */
        private Node<T> last;

        /**
         * 定义队列大小
         */
        private int size;

        /**
         * 从队列头部插值
         *
         * @param t 元素
         */
        public void offer(T t) {
            // 给新加入的值创建一个节点
            Node<T> cur = new Node<>(t);
            // 判断当前队列中是否存在值
            if (size == 0) {
                // 如果是第一个元素头部指向当前元素
                head = cur;
                // 尾部指向当前元素
                last = cur;
            } else {
                // 不是第一个元素,当前尾部的next指针指向当前元素
                last.next = cur;
                // 当前尾部指针指向当前元素(因为当前元素才是现在的尾部)
                last = cur;
            }
            // 队列数量加一
            size++;
        }

        /**
         * 获取队列中头部元素
         *
         * @return 元素值
         */
        public T poll() {
            // 定义返回对象
            T result = null;
            if (head != null) {
                // 设置返回值为head的val
                result = head.val;
                // 当前元素不为空时,需要把head指针指向下一个元素
                head = head.next;
                // 取出元素后size减一
                size--;
            } else {
                // 当只有一个元素时头部尾部头指向他,他被拿走了,head指向了head.next
                // 但是last依旧指向他,导致不能被JVM回收,所以需要手动释放
                last = null;
            }
            return result;
        }


        /**
         * 当前集合是否为空
         *
         * @return 为空返回true 否则返回false
         */
        public boolean isEmpty() {
            return size == 0;
        }
    }

    /**
     * 测试队列 -- > 抽空写成对数器
     */
    public static void testQuery() {
        MyQueue<String> queue = new MyQueue<>();
        queue.offer("12");
        queue.offer("13");
        queue.offer("14");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    /**
     * 自定义栈
     *
     * @param <T> 泛型
     */
    public static class MyStack<T> {
        /**
         * 定义头部指针
         */
        private Node<T> head;

        /**
         * 定义栈大小
         */
        private int size;

        /**
         * 判断栈是否为空
         *
         * @return true 代表还有值,false代表没值了
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * 压栈
         *
         * @param t 元素
         */
        public void push(T t) {
            // 为新加入的元素创建一个节点
            Node<T> cur = new Node<>(t);
            if (size == 0) {
                // 如果当前栈内是空的,只需药指定head为当前元素即可
                head = cur;
            } else {
                // 如果当前栈内有值,需要设置当前元素为head的上一个节点
                cur.next = head;
                // 把指针移到cur的位置
                head = cur;
            }
            // size 加一
            size++;
        }

        /**
         * 弹栈
         *
         * @return 元素
         */
        public T pop() {
            T result = null;
            if (head != null) {
                // 如果头部节点不空就把head的val返回
                result = head.val;
                // 设置指针位置为弹出元素的下一个节点
                head = head.next;
                // size 减一
                size--;
            }

            return result;
        }


    }

    /**
     * 测试队列 -- > 抽空写成对数器
     */
    public static void testStack() {
        MyStack<String> myStack = new MyStack<>();
        myStack.push("1");
        myStack.push("2");
        myStack.push("3");
        myStack.push("4");

        while (!myStack.isEmpty()) {
            System.out.println(myStack.pop());
        }
    }

    public static void main(String[] args) {
        // 测试队列
        testQuery();
        System.out.println("======================");
        // 测试栈
        testStack();
    }

}
