/* 
 * 把二叉树打印成多行
 * 题目描述:
 *     从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。 
 *
 * 思路:
 *     通过队列层序遍历二叉树，在进队时统计该层的结点数，当该层结点数的值都存入链表中时将该层存进result，开始存下一层的结点值，
 * 并统计再下一层的结点数。
 */
import java.util.ArrayList;
import java.util.LinkedList;

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
public class PrintSolution {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        int num = 1, nextNum = 0;
        queue.offer(pRoot);
        while(queue.peek() != null) {
            ArrayList<Integer> row = new ArrayList<>();
            while(num != 0) {
                TreeNode node = queue.poll();
                num--;
                row.add(node.val);
                if(node.left != null) {
                    nextNum++;
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    nextNum++;
                    queue.offer(node.right);
                }
            }
            result.add(row);
            num = nextNum;
            nextNum = 0;
        }
        return result;
    }
}
