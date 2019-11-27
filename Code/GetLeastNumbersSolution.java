/*
 * 最小的K个数
 * 题目描述:
 *     输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 *
 * 思路:
 *     利用ArrayList实现最大堆，本质是完全二叉树，可以根据父节点得到子节点的位置，也可以通过子节点得到父节点的位置。当
 * 所求的最小k个数时k大于原输入数组长度或为0时，不进行计算，返回空列表。否则，当列表中元素少于k时，存入堆底，并比较其与
 * 父节点的大小关系，每次插入后将最大值移至堆顶。当列表已满时，比较当前数组值和堆顶值的大小，若大于堆顶值，则无需存入，
 * 否则替换堆顶值，并将其与子节点进行比较，每次插入后调整使得最大值位于堆顶，这一步复杂度为O(log(k)),故算法总的复杂度为
 * O(nlog(k))。
 */
import java.util.ArrayList;

public class GetLeastNumbersSolution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(input.length >= k && k > 0) {
            int n = 0;
            for(int i = 0; i < input.length; i++) {
                if(n < k) {
                    result.add(input[i]);
                    n++;
                    int index = i;
                    int fatherIndex = i % 2 == 1 ? (i - 1) / 2 : (i - 2) / 2;
                    while(fatherIndex >= 0 && result.get(index) > result.get(fatherIndex)) {
                        int temp = result.get(index);
                        result.set(index, result.get(fatherIndex));
                        result.set(fatherIndex, temp);
                        index = fatherIndex;
                        fatherIndex = index % 2 == 1 ? (index - 1) / 2 : (index - 2) / 2;
                    }
                } else if(input[i] < result.get(0)) {
                    result.set(0, input[i]);
                    int index = 0;
                    int sonIndex = 2 * index + 1;
                    while(sonIndex < k) {
                        boolean check = sonIndex + 1 < k;
                        if(result.get(index) >= result.get(sonIndex) && 
                           (!check || result.get(index) >= result.get(sonIndex+1))) {
                            break;
                        }
                        int temp = result.get(index);
                        if(result.get(index) < result.get(sonIndex) &&
                          (!check || result.get(sonIndex) > result.get(sonIndex + 1))){
                            result.set(index, result.get(sonIndex));
                            result.set(sonIndex, temp);
                            index = sonIndex;
                        } else {
                            result.set(index, result.get(sonIndex + 1));
                            result.set(sonIndex + 1, temp);
                            index = sonIndex + 1;
                        }
                        sonIndex = 2 * index + 1;
                    }
                } else {
                    continue;
                }
            }
        }
        return result;
    }
}

