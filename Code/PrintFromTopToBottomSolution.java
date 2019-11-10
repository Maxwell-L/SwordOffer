/*
 * 从上往下打印二叉树
 * 题目描述:
 *     从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 
 * 思路:
 *     若根节点不为空将其存进队列中，循环内每次将队列头取出，判断其左右节点是否为空，不为空则存进队列，并将取出的节点的值存进result。
 */
import java.util.ArrayList;
import java.util.LinkedList;
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
*/
public class PrintFromTopToBottomSolution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }
        while(queue.peek() != null){
            TreeNode cur = queue.poll();
            if(cur.left != null) {
                queue.offer(cur.left);
            }
            if(cur.right != null) {
                queue.offer(cur.right);
            }
            result.add(cur.val);
        }
        return result;
    }
}
