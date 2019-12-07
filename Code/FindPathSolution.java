/*
 * 二叉树中和为某一值的路径
 * 题目描述:
 *     输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到
 * 叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)。
 *
 * 思路:
 *     通过递归来遍历函数，当判断到该路径和为target时，将其添加到result中，否则直接返回。
 */
import java.util.ArrayList;
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
public class FindPathSolution {
    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path, TreeNode root, int target) {
        ArrayList<Integer> temp = new ArrayList<>(path);
        temp.add(root.val);
        if(root.left == null && root.right == null && target - root.val == 0) {
            result.add(temp);
            return;
        }
        if(root.left == null && root.right == null && target - root.val != 0) {
            return;
        }
        if(root.left != null) {
            helper(result, temp, root.left, target - root.val);
        }
        if(root.right != null) {
            helper(result, temp, root.right, target - root.val);
        }
        return;
    }
    
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root != null) {
            helper(result, new ArrayList<Integer>(), root, target);
        }
        return result;
    }
}
