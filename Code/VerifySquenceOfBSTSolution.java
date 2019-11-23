/*
 * 二叉搜索树的后序遍历序列
 * 题目描述:
 *    输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 * 
 * 思路:
 *     二叉搜索树后序遍历序列中最后一个结点为根节点，序列前一部分为左子树，后一部分为右子树，遍历序列，当发现第一个比根节点的值
 * 大的结点时，该结点之前为左子树，若在此结点之后发现仍有比根节点的值小的结点，说明该序列不是二叉搜索树的后序遍历序列。以此作为
 * 判据进行判决。若当前序列无误，则将其分为左子树和右子树序列，递归计算左右子树是否符合后序遍历，直至序列中仅有一个结点。
 */
public class VerifySquenceOfBSTSolution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0) {
            return false;
        }
        if(sequence.length == 1) {
            return true;
        }
        int root = sequence[sequence.length - 1];
        int left = 0, right = 0;
        for(int i = 0; i < sequence.length - 1; i++) {
            if(sequence[i] < root && right == 0){
                left++;
            } else if(sequence[i] > root) {
                right++;
            } else {
                return false;
            }
        }
        int[] leftSequence = new int[left], rightSequence = new int[right];
        for(int i = 0, j = 0; i < sequence.length - 1; i++, j++){
            if(i < left){
                leftSequence[j] = sequence[i];
            } 
            if(i == left){
                j = 0;
            }
            if(i >= left) {
                rightSequence[j] = sequence[i];
            }
        }
        boolean leftCheck = true, rightCheck = true;
        if(left > 0){
            leftCheck &= VerifySquenceOfBST(leftSequence);
        }
        if(right > 0){
            rightCheck &= VerifySquenceOfBST(rightSequence);
        }
        return  leftCheck & rightCheck;
    }
}

