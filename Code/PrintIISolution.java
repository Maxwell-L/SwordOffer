/*
 * 按之字形顺序打印二叉树
 * 题目描述:
 *     请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左
 * 到右的顺序打印，其他行以此类推。
 *
 * 思路:
 *     利用栈来存储每一层的结点，为了便于分层和存储，采用两个栈来存储不同层的结点。栈1存储的层从左到右打印，故结点进栈时
 * 右结点应先入栈，左结点后入栈。与之相反，栈2存储的层从右到左打印，故结点进栈时左结点先入栈右结点后入栈
 */
import java.util.ArrayList;
import java.util.Stack;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
*/
public class PrintIISolution {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        if(pRoot != null) {
            stack1.push(pRoot);
        }
        while(!stack1.empty()) {
            if(!stack1.empty()) {
                ArrayList<Integer> temp = new ArrayList<>();
                while(!stack1.empty()) {
                    TreeNode node = stack1.pop();
                    temp.add(node.val);
                    if(node.left != null) {
                        stack2.push(node.left);
                    }
                    if(node.right != null) {
                        stack2.push(node.right);
                    }
                }
                result.add(temp);
            }
            if(!stack2.empty()) {
                ArrayList<Integer> temp = new ArrayList<>();
                while(!stack2.empty()) {
                    TreeNode node = stack2.pop();
                    temp.add(node.val);
                    if(node.right != null) {
                        stack1.push(node.right);
                    }
                    if(node.left != null) {
                        stack1.push(node.left);
                    }
                }
                result.add(temp);
            }
        }
        return result;
    }
}
