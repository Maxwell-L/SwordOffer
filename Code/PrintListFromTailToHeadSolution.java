/*
 * 从尾到头打印链表
 * 题目描述:
 *     输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 *
 * 思路:
 *     遍历链表，依次将值压入栈中，完成后将栈中数据依次弹出并保存到ArrayList中。
 */
 /**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*/
import java.util.ArrayList;
import java.util.Stack;
public class PrintListFromTailToHeadSolution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(ListNode p = listNode; p != null; p = p.next){
            stack.push(p.val);
        }
        while(!stack.empty()) {
            result.add(stack.pop());
        }
        return result;
    }
}
