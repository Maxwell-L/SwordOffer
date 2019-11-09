/*
 * 二进制中1的个数
 * 题目描述:
 *     输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 
 * 思路:
 *     将 n 按位与 1 进行与运算，如果为 1 说明 n 的二进制表示中最后一位是 1，计数器加一，将 n 右移一位继续计算，直到 n 为 0。
 */
public class NumberOf1Solution {
    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0){
            count = (n & 1) == 1 ? count + 1 : count;
            n >>>= 1;
        }
        return count;
    }
}
