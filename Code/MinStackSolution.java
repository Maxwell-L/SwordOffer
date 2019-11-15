/*
 * 包含min函数的栈
 * 题目描述:
 *     定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数(时间复杂度应为O(1))。
 *
 * 思路:
 *     定义两个栈，一个存储数据，一个存储最小值。push时数据压入数据栈，然后判断该值与最小值栈栈顶值的大小关系，将小值压入最小值栈。弹出时同时弹出
 * 两个栈栈顶的元素。
 */
import java.util.Stack;

public class MinStackSolution {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    
    public void push(int node) {
        dataStack.push(node);
        minStack.push((minStack.empty() || node < minStack.peek()) ? node : minStack.peek());
    }
    
    public void pop() {
        dataStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return dataStack.peek();
    }
    
    public int min() {
        return minStack.peek();
    }
}
