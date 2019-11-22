/*
 * 重建二叉树
 * 题目描述:
 *     输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 
 * 思路:
 *     1、若遍历序列长度为0，则说明该(子)树为空，返回null。
 *     2、若遍历序列长度为1，则说明该(子)树只有一个元素，返回该结点。
 *     3、二叉树前序遍历中的第一个结点为根节点，据此找到中序遍历中根节点的位置，左边既是根节点的左子树，右边既是右子树。而前序遍历中
 * 是先打印根节点，后遍历左子树，最后遍历右子树，可由此将左右子树的前序遍历和中序遍历分别找出，递归建树。
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ReConstructBinaryTreeSolution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0) {
            return null;
        }
        if(pre.length == 1) {
            return new TreeNode(pre[0]);
        }
        int index = 0;
        for(int i = 0; i < pre.length; i++){
            if(in[i] == pre[0]) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(in[index]);
        int[] leftPre = new int[index], leftIn = new int[index];
        int[] rightPre = new int[pre.length - index - 1], rightIn = new int[pre.length - index - 1];
        for(int i = 1, j = 0; i < pre.length; i++, j++){
            if(i <= index){
                leftPre[j] = pre[i];
            }
            if(i == index){
                j = -1;
            }
            if(i > index){
                rightPre[j] = pre[i];
            }
        }
        for(int i = 0, j = 0; i < in.length; i++, j++) {
            if(i < index){
                leftIn[j] = in[i];
            } else if(i == index) {
                j = -1;
            } else {
                rightIn[j] = in[i];
            }
        }
        root.left = reConstructBinaryTree(leftPre, leftIn);
        root.right = reConstructBinaryTree(rightPre, rightIn);
        return root;
    }
}

