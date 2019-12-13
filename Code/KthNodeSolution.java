/*
 * 二叉搜索树的第k个结点
 * 题目描述:
 *     给定一棵二叉搜索树，请找出其中的第k小的结点。例如,(5，3，7，2，4，6，8)中，按结点数值大小顺序第三小结点的值为4。
 * 
 * 思路:
 *     中序遍历二叉搜索树即可得到树的有序遍历，记录到第k个结点时返回即可。 
 */
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
import java.util.Stack;

public class KthNodeSolution {
    public TreeNode KthNode(TreeNode pRoot, int k) {
        if(pRoot == null || k == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = pRoot;
        int count = 0;
        while(p != null || !stack.empty()) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                count++;
                if(count == k) {
                    return p;
                }
                p = p.right;
            }
        }
        return null;
    }
}
