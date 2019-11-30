/*
 * 和为S的连续正数序列
 * 题目描述:
 *     小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想
 * 究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现
 * 在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * 思路:
 *     定义正数序列的最小值为min，最大值为max，利用等差数列求和公式求出序列和，当序列和等于S时，将此时的序列存入result，然后
 * 最小值右移。当序列和小于S时，序列最大值右移，序列和大于S时，最小值右移，以此类推，直到最小值大于S的一半，此时以最小值为开始
 * 的序列和不可能再等于S，退出循环，返回result。
 */
import java.util.ArrayList;
public class FindContinuousSequenceSolution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();
        int min = 1, max = 2;
        while(min <= sum / 2) {
            if((min + max) * (max - min + 1) / 2 == sum) {
                ArrayList<Integer> temp = new ArrayList<>();
                for(int i = min; i <= max; i++) {
                    temp.add(i);
                }
                result.add(temp);
                min++;
            } else if((min + max) * (max - min + 1) / 2 < sum) {
                max++;
            } else {
                min++;
            }
        }
        return result;
    }
}

