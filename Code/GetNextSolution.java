/*
 * 二叉树的下一个结点
 * 题目描述:
 *     给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结
 * 点，同时包含指向父结点的指针。
 * 
 * 思路:
 *     中序遍历是先遍历左子树，访问根节点，再遍历右子树。如果给出的结点存在右子树，则下一个结点是右子树的最左结点；若结点不存在右子
 * 树，则应判断该结点是否为左子树，若是，则返回其父节点，否则应向上遍历直到找到该结点所在子树是左子树的父结点。
 */
/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
public class GetNextSolution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode p = pNode;
        if(p.right != null) {
            p = p.right;
            while(p.left != null) {
                p = p.left;
            }
        } else {
            while(p.next != null && p.next.right == p) {
                p = p.next;
            }
            p = p.next;
        }
        return p;
    }
}

