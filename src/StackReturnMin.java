import java.util.Stack;

/**
 * 实现一个特殊的栈,在基本功能上加入返回栈中最小元素的功能
 *
 * @author chao
 */
public class StackReturnMin {
    /**
     * 栈
     */
    private final Stack<Integer> stack = new Stack<>();

    /**
     * 最小栈
     */
    private final Stack<Integer> minStack = new Stack<>();

    /**
     * 压栈
     *
     * @param i i
     */
    public void push(Integer i) {
        stack.push(i);
        // 如果新进栈的数据 < 栈顶位置的数就进栈,否则在压入一次栈顶数据
        minStack.push((minStack.isEmpty() || minStack.peek() > i) ? i : minStack.peek());
    }

    public int pop() {
        minStack.pop();
        return stack.pop();
    }

    public int getMin() {
        return minStack.peek();
    }


    public static void main(String[] args) {
        StackReturnMin stack1 = new StackReturnMin();
        stack1.push(3);
        System.out.println("==============栈最小值为================");
        System.out.println(stack1.getMin());
        System.out.println("======================================");
        stack1.push(4);
        System.out.println("==============栈最小值为================");
        System.out.println(stack1.getMin());
        System.out.println("======================================");
        stack1.push(1);
        System.out.println("==============栈最小值为================");
        System.out.println(stack1.getMin());
        System.out.println("======================================");
        System.out.println("==============弹出栈================");
        System.out.println(stack1.pop());
        System.out.println(stack1.getMin());
    }
}
