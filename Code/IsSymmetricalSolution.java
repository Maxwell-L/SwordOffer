/*
 * 对称的二叉树
 * 题目描述:
 *     请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * 思路:
 *     若二叉树对称，则左子树与右子树对称，左子树的左子树与右子树的右子树对称，左子树的右子树与右子树的左子树对称，由此
 * 可构建递归函数进行判断，若左右子树结点为空，则返回true，若其中一个不为空或者对应的两结点值不同，则返回false，否则判断
 * 其左结点的左子树与右结点的右子树是否对称以及左结点的右子树与右结点的左子树是否对称。
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
public class IsSymmetricalSolution {
    private boolean helper(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
        if(left.val != right.val) {
            return false;
        }
        return helper(left.left ,right.right) && helper(left.right, right.left);
    }
    
    public boolean isSymmetrical(TreeNode pRoot){
        return helper(pRoot, pRoot);
    }
}
