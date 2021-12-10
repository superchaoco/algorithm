import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

/**
 * 数组实现队列
 *
 * @author chao
 */
public class ArrayImplQueue {
    /**
     * push指针
     */
    private int pushPoint = 0;

    /**
     * pop指针
     */
    private int popPoint = 0;

    /**
     * 队列大小
     */
    private int size;

    /**
     * 队列容量
     */
    private final int capacity;

    /**
     * 定义接受数据的数组
     */
    private final int[] arr;

    /**
     * 构造函数置顶队列大小
     *
     * @param capacity 队列大小
     */
    public ArrayImplQueue(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
    }

    /**
     * 队列push
     *
     * @param ans push的数据
     */
    public void push(int ans) {
        // 如果队列中数据达到数组最大值,此时push报错
        if (size == capacity) {
            throw new RuntimeException("队列已满");
        }
        // 如果没满,向push位置添加
        arr[pushPoint] = ans;
        // push位置自增
        pushPoint = pointAdd(pushPoint);
        // size + 1
        size++;
    }

    private int pointAdd(int i) {
        return i == (capacity - 1) ? 0 : i + 1;
    }

    /**
     * 队列抛出数据
     *
     * @return 队列数据
     */
    public int pop() {
        if (size == 0) {
            throw new RuntimeException("元素为空");
        }
        // 如果有元素返回pop指针位置的数pop指针+1
        int result = arr[popPoint];
        // push位置自增
        popPoint = pointAdd(popPoint);
        // size + 1
        size--;
        return result;
    }

    public int peek() {
        if (size == 0) {
            throw new RuntimeException("元素为空");
        }
        return arr[popPoint];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        // 定义测试次数
        int count = 100000;
        // 定义数组最大长度;
        int max = 100;
        for (int i = 0; i < count; i++) {
            // 随机队列容量
            int c = (int) (Math.random() * max + 1);
            LinkedList<Integer> queue1 = new LinkedList<>();
            ArrayImplQueue queue2 = new ArrayImplQueue(c);
            // 给随机样本加入数据
            for (int i1 = 0; i1 < c; i1++) {
                int num = (int) (Math.random() * max + 1) - (int) (Math.random() * max + 1);
                queue1.add(num);
                queue2.push(num);

                double random = Math.random();
                if (random >= 0.6) {
                    Integer pop = queue1.pop();
                    int pop1 = queue2.pop();
                    if(pop != pop1){
                        System.out.printf("错误,自己写的[%s],人家的[%s]%n",pop1,pop);
                        System.out.println("==================人家的");
                        for (Integer integer : queue1) {
                            System.out.print(integer + " ");
                        }
                        System.out.println();
                        System.out.println("==================自己的");
                        System.out.println(Arrays.toString(queue2.arr));
                        return;
                    }
                } else if (random >= 0.3) {
                    Integer peek = queue1.peek();
                    Integer peek2 = queue2.peek();
                    if(!Objects.equals(peek, peek2)){
                        System.out.printf("错误,自己写的[%s],人家的[%s]%n",peek,peek2);
                        System.out.println("==================人家的");
                        for (Integer integer : queue1) {
                            System.out.print(integer);
                        }
                        System.out.println();
                        System.out.println("==================自己的");
                        System.out.println(Arrays.toString(queue2.arr));
                        return;
                    }
                }
            }
        }
        System.out.println("测试通过");
    }
}
