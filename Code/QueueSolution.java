/*
 * 用两个栈实现队列
 * 题目描述:
 *     用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 
 * 思路:
 *     其中一个栈用来存储输入数据，当要取出数据时，将数据搬移到另一个栈中，此时最先输入的数据会在另一个栈的顶部，暂存后将数据重新输入回栈1，
 * 返回该数据。
 *
 */
import java.util.Stack;

public class QueueSolution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return result;
    }
}