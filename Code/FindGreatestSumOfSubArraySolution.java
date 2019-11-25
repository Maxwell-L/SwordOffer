/*
 * 连续子数组的最大和
 * 题目描述:
 *     HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算
 * 连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥
 * 补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的
 * 和，你会不会被他忽悠住？(子向量的长度至少是1)。
 *
 * 思路:
 *     运用动态规划的思想，用f[i]来表示第i个元素结尾的子数组的最大和，当i为0或f[i-1]为负数时，f[i]为当前元素；否则，
 * f[i] = f[i-1] + array[i]，最后取max(f[i])即为连续子数组的最大和。
 */
public class FindGreatestSumOfSubArraySolution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int[] f = new int[array.length];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++) {
            if(i == 0 || f[i-1] < 0){
                f[i] = array[i];
            } else {
                f[i] = f[i-1] + array[i];
            }
            max = f[i] > max ? f[i] : max;
        }
        return max;
    }
}

