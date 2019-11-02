/*
 * 斐波那契数列
 * 题目描述：
 *     大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
 *
 * 思路：
 *    斐波那契数列：f(n) = f(n-1) + f(n-2), 第1项和第2项为 1。
 */
 
public class FibonacciSolution {
    public int Fibonacci(int n) {
        if(n <= 1){
            return n;
        }
        int pre = 0, cur = 1, result = 0, i = 1;
        while(i < n){
            result = pre + cur;
            pre = cur;
            cur = result;
            i++;
        }
        return result;
    }
}