/* 
 * 矩形覆盖
 * 题目描述:
 *     我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 思路:
 *     当有 2*n 的大矩形时，可以看成是 1 个竖放的 2*1 小矩形和一个 2*(n-1) 大矩形组合或者 2 个横放的 2*1 小矩形 和一个 2*(n-2) 大矩形组合，
 * 假设 f(n) 为覆盖 2*n 的大矩形的方法种数，则可得 f(n) = f(n-1) + f(n-2)。
 */
 
public class RectCoverSolution {
    public int RectCover(int target) {
        int result = 0, prepre = 0, pre = 1, i = 0;
        while(i < target){
            result = prepre + pre;
            prepre = pre;
            pre = result;
            i++;
        }
        return result;
    }
}
