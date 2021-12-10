import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列实现栈
 *
 * @author chao
 */
public class QueueImplStack<T> {
    /**
     * 队列
     */
    private Queue<T> queue;

    /**
     * 帮助队列
     */
    private Queue<T> help;

    public QueueImplStack() {
        queue = new LinkedList<>();
        help = new LinkedList<>();
    }

    public void push(T t) {
        queue.offer(t);
    }

    public T pop() {
        while (queue.size() > 1) {
            help.offer(queue.poll());
        }
        T poll = queue.poll();
        Queue<T> temp = queue;
        queue = help;
        help = temp;
        return poll;
    }


    public static void main(String[] args) {
        QueueImplStack<String> queue = new QueueImplStack<>();
        queue.push("1");
        queue.push("2");
        queue.push("3");

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
