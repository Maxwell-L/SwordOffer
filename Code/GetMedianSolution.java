/*
 * 数据流中的中位数
 * 题目描述:
 *     如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流
 * 中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获
 * 取当前读取数据的中位数。
 * 
 * 思路:
 *     使用 ArrayList 存储和排序数据，根据下标直接计算中位数。
 */

import java.util.ArrayList;

public class GetMedianSolution {
    private ArrayList<Integer> nums = new ArrayList<>();
    private int size = 0;
    
    public void Insert(Integer num) {
        for(int i = 0; i <= size; i++) {
            if(i == size) {
                nums.add(num);
            } else if(num <= nums.get(i)) {
                nums.add(i, num);
                break;
            }
        }
        size++;
    }

    public Double GetMedian() {
        if(size % 2 == 1) {
            return (double)nums.get(size / 2);
        } else {
            return (double)(nums.get(size / 2 - 1) + nums.get(size / 2)) / 2.0;
        }
    }
}