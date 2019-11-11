/*
 * 二叉树的镜像
 * 题目描述:
 *     操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 思路:
 *     如果结点不为空，交换其左右结点，对其左右子树作同样的镜像翻转。
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
public class MirrorSolution {
    public void Mirror(TreeNode root) {
        if(root != null){
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
            Mirror(root.left);
            Mirror(root.right);
        }
    }
}
