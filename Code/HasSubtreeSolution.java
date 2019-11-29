/*
 * 树的子结构
 * 题目描述:
 *     输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 
 * 思路:
 *     递归遍历二叉树A，当找到与B树的根结点的值相同的结点时，通过check()函数判断是否为子结构，是则返回true，否则寻找下一个
 * 与B树根结点的值相同的结点。
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
public class HasSubtreeSolution {
    private boolean check(TreeNode root1, TreeNode root2) {
        if(root2 == null) {
            return true;
        }
        if(root1 == null) {
            return false;
        }
        if(root1.val != root2.val) {
            return false;
        }
        return check(root1.left, root2.left) && check(root1.right, root2.right);
    }
    
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null) {
            return false;
        }
        return check(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }
}

