import java.util.Stack;

/**
 * 栈实现队列 == > 思路是定义两个栈一个push栈一个pop栈
 * 遵循两个规范把push栈的数据倒给pop栈
 * 1 . push栈倒数据一次性必须全部倒出
 * 2 . 只有在pop栈为空的时候才能倒入
 * 满足两个条件后就可以实现
 *
 * @author chao
 */
public class StackImplQueue<T> {
    /**
     * 定义一个push栈
     */
    private final Stack<T> pushStack = new Stack<>();

    /**
     * 定义一个pop栈
     */
    private final Stack<T> popStack = new Stack<>();

    public void offer(T t) {
        pushStack.push(t);
        // 调用倒入方法
        pourOut();
    }

    public T poll() {
        // 尝试倒出
        pourOut();
        return popStack.pop();
    }

    /**
     * pop栈为空就把pushStack全部倒入
     */
    private void pourOut() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
    }

    public boolean isEmpty(){
        return popStack.isEmpty() && pushStack.isEmpty();
    }

    public static void main(String[] args) {
        StackImplQueue<String> stack = new StackImplQueue<>();
        stack.offer("第一个");
        stack.offer("第二个");
        stack.offer("第三个");
        while (!stack.isEmpty()){
            System.out.println(stack.poll());
        }

        stack.offer("第四个");
        stack.offer("第五个");

        while (!stack.isEmpty()){
            System.out.println(stack.poll());
        }
    }
}
