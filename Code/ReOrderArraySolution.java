/*
 * 调整数组顺序使奇数位于偶数前面
 * 题目描述:
 *     输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 
 * 思路:
 *     利用一个 index 记录数组下标，奇数按照 index 位置存储，偶数暂存到队列中(LinkedList实现了Queue接口)，遍历结束后将偶数依次存入数组中。
 */
import java.util.LinkedList;

public class ReOrderArraySolution {
    public void reOrderArray(int [] array) {
        LinkedList<Integer> queue = new LinkedList<>();
        int index = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] % 2 == 1) {
                array[index] = array[i];
                index++;
            } else {
                queue.offer(array[i]);
            }
        }
        while(index < array.length && queue.peek() != null) {
            array[index] = queue.poll();
            index++;
        }
    }
}
