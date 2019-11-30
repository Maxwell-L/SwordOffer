/*
 * 和为S的两个数字
 * 题目描述:
 *     输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 思路:
 *     设置两个指针分别指向首尾，若两数和为S，由于 axb < (a+k)(b+k)，可知最先找到的两数乘积一定为最小，可存入列表并返回。若两数和
 * 小于S，则左指针右移，若大于S则右指针左移，直到找到答案。
 */
import java.util.ArrayList;
public class FindNumbersWithSumSolution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int left = 0, right = array.length - 1;
        while(left < right) {
            if(array[left] + array[right] == sum) {
                result.add(array[left]);
                result.add(array[right]);
                break;
            }
            if(array[left] + array[right] < sum) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
