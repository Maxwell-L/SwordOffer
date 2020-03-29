/*
 * 整数中1出现的次数（从1到n整数中1出现的次数）
 * 题目描述:
 *     求出 1 ~ 13 的整数中 1 出现的次数,并算出 100 ~ 1300 的整数中 1 出现的次数？为此他特别数了一下 1 ~ 13 中
 * 包含 1 的数字有 1、10、11、12、13 因此共出现 6 次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加
 * 普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 *
 * 思路:
 *     1、假设输入整数 n = abcde，分成 bcde + 1 ~ n 和 1 ~ bcde两部分。
 *     2、计算 bcde + 1 ~ n 这部分中 1 的个数，分别计算最高位是 1 的个数和剩下位数 1 的个数（组合）。
 *     3、1 ~ bcde部分通过递归完成计算。
 */

public class NumberOf1Between1AndNSolution {
    public int NumberOf1Between1AndN_Solution(int n) {
        return numberOf1(Integer.toString(n).toCharArray(), n, 0);
    }
    
    private static int numberOf1(char[] num, int n, int index) {
        if(index == num.length - 1 && num[index] == '0') {
            return 0;
        }
        if(index == num.length - 1 && num[index] > '0') {
            return 1;
        }
        int first = num[index] - '0';
        int w = bit((num.length - index) - 1);
        int high = 0, mid = 0;
        if(first > 0) {
            high = (first - 1) == 0 ? n % w + 1 : w;
        }
        mid = first * (w / 10) * (num.length - index - 1);
        return high + mid + numberOf1(num, n, index + 1);
    }
    
    private static int bit(int len) {
        int w = 1;
        for(int i = 0; i < len; i++) {
            w *= 10;
        }
        return w;
    }
}