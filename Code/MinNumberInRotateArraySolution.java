/*
 * 旋转数组的最小数字
 * 题目描述:
 *     把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *     NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 思路:
 *     1、数组长度为0，直接返回0。
 *     2、左右指针指向数组两端，循环条件为左值大于右值(旋转)，若左右指针相邻，则说明右值已是最小值。
 *     3、若左右中值均相等，只能采用遍历的方法寻找。
 *     4、若中值大于左值，则说明左半部分有序，最小值在右半部分，反之则在左半部分，由此改变左右指针，循环直到左右指针相邻。
 */
import java.util.ArrayList;
public class MinNumberInRotateArraySolution {
    public int minNumberInRotateArray(int [] array) {
        if(array.length <= 0) {
            return 0;
        }
        int left = 0, right = array.length - 1, mid = 0;
        while(array[left] >= array[right]) {
            if(right - left == 1) {
                return array[right];
            }
            mid = (left + right) / 2;
            if(array[left] == array[right] && array[left] == array[mid]) {
                int result = array[left];
                for(int i = left + 1; i <= right; i++) {
                    result = result < array[i] ? result : array[i];
                }
                return result;
            }
            if(array[mid] >= array[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return array[mid];
    }
}
