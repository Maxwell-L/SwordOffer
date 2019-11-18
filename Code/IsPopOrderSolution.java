/*
 * 栈的压入、弹出序列、
 * 题目描述:
 *     输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 *（注意：这两个序列的长度是相等的）
 *
 * 思路:
 *     定义一个辅助栈，模拟压入、弹出过程；遍历压入序列，依次压入数字，当压入的数字与弹出序列指针所指向的数字相同时，弹出栈顶元素，并判断
 * 弹出序列指针的下一个数字是否和栈顶元素相同，直到不同时再压入下一个数字。若第二个序列为栈的弹出顺序，则循环结束后栈应该为空，若不是栈的弹出
 * 序列，则栈不为空，故结果返回 stack.empty()。
 */
import java.util.Stack;

public class IsPopOrderSolution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0, popIndex = 0;
        while(pushIndex < pushA.length) {
            stack.push(pushA[pushIndex++]);
            while(popIndex < popA.length && popA[popIndex] == stack.peek()) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.empty();
    }
}
