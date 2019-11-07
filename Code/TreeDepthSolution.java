/*
 * 二叉树的深度
 * 题目描述:
 *     输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 思路:
 *     1、若结点为空，则以该结点为根结点的树深度为 0。
 *     2、结点不为空，则以该结点为根结点的树的深度为该层深度(1)加上左右子树的最大深度。
 */
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
public class TreeDepthSolution {
    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }
}
