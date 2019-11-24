/*
 * 二叉搜索树与双向链表
 * 题目描述:
 *     输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 思路:
 *     链表要求有序，应采用中序遍历二叉树，设置头节点以及链表指针，当头结点为空时将结点赋给头结点，不为空时将链表指针右指针
 * 指向当前结点，当前结点左指针指向链表指针指向的结点，遍历完成时链表同时构造完成。
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
import java.util.Stack;

public class ConvertSolution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = pRootOfTree, head = null, q = null;
        while(p != null || !stack.empty()){
            if(p != null){
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                if(head == null){
                    head = p;
                    q = head;
                } else {
                    q.right = p;
                    p.left = q;
                    q = q.right;
                }
                p = p.right;
            }
        }
        return head;
    }
}

