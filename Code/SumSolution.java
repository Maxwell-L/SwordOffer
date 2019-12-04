/*
 * 求1+2+3+...+n
 * 题目描述:
 *     求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 思路:
 *     由等差数列求和公式得 sum = n(1 + n) / 2 = (n^2 + n) / 2。定义pow(int n, int m)函数求平方，利用 && 短路的特点以及递归求解。
 *     假设求 9^2，可视为 9 * 9 = 9 * (1001)B = 9 * 1 + (9 * 0 + ((9 * 0 + (9 * 1) << 1) << 1) << 1)，将 n 作为参数输入，一个作为
 * 固定不变的数，另一个用于位运算右移。当 m = 0 时，返回 0，否则该层函数值等于下层函数左移1位，再判断当前位二进制是否为1，若为 1
 * 加上 n，否则不加；返回该值。
 *     主函数直接利用公式 sum = (n^2 + n) / 2 求解，将 /2 替换成 >> 1 即可。
 */
public class SumSolution {
    private int pow(int n, int m) {
        int temp = 0;
        boolean flag = m > 0 && (temp = pow(n, m >> 1) << 1) >= 0 && (m & 1) > 0 && (temp += n) > 0;
        return temp;
    }
    
    public int Sum_Solution(int n) {
        return (n + pow(n, n)) >> 1;
    }
}

