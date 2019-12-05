/* 
 * 剪绳子
 * 题目描述:
 *     给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。
 * 请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的
 * 最大乘积是18。
 *
 * 思路:
 *     利用贪心算法的思想，乘积要取最大时应尽量将其分为长度为2或3的段，令 3(n-3) >= 2(n-2)，解的 n >= 5。故对于 n < 5的数
 * 可以先探求出答案，n = 2 可分为两段长度为 1，n = 3可分为一段 1 一段 2，n = 4 分为两段 2。当 n >= 5，可先将 n 分为长度为
 * 3 的若干份，若 n 刚好为 3 的倍数，则将若干个 3 相乘即可；若 n 模 3 余 1，则说明最后剩下的 4 分成了 1 和 3，前面已经得知
 * 4 的分法应该为 2 x 2 = 4，可将若干个 3 相乘后除以 3 再乘 4，若 n 模 3 余 2，则将若干个 3 相乘后再乘最后的 2 即可。
 */
public class CutRopeSolution {
    public int cutRope(int target) {
        if(target < 4) {
            return target - 1;
        }
        int div = target / 3, mod = target % 3;
        int result = mod == 0 ? 1 : (mod == 1 ? 4 : 2);
        div = mod == 1 ? div - 1 : div;
        while(div != 0) {
            result *= 3;
            div--;
        }
        return result;
    }
}

