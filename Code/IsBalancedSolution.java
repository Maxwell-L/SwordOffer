/*
 * 平衡二叉树
 * 题目描述:
 *     输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 思路:
 *     定义一个获取树深度的函数depth()，当左子树不平衡时，返回-1，当右子树不平衡时，返回-1。若左右子树都平衡，则判断两子
 * 树构成的母树是否平衡，不平衡返回-1，平衡返回树深度。主函数中直接根据depth()函数的返回值是否为-1即可判断是否平衡。
 */
public class IsBalancedSolution {
    private int depth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = depth(root.left);
        if(left == -1){
            return -1;
        }
        int right = depth(root.right);
        if(right == -1) {
            return -1;
        }
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
    
    public boolean IsBalanced_Solution(TreeNode root) {
        return depth(root) != -1;
    }
}
