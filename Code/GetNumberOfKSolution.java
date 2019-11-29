/*
 * 数字在排序数组中出现的次数
 * 题目描述:
 *     统计一个数字在排序数组中出现的次数。
 * 
 * 思路:
 *     通过二分查找分别找到第一个K的位置和最后一个K的位置，计算得出K出现的次数。
 */
public class GetNumberOfKSolution {
    private int GetFirstOfK(int[] array, int k){
        int left = 0, right = array.length-1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(array[mid] == k && (mid == 0 || array[mid-1] < k)) {
                return mid;
            }
            if(array[mid] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    
    private int GetLastOfK(int[] array, int k){
        int left = 0, right = array.length-1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(array[mid] == k && (mid == array.length - 1 || array[mid+1] > k)) {
                return mid;
            }
            if(array[mid] > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    
    public int GetNumberOfK(int [] array , int k) {
        int first = GetFirstOfK(array, k);
        int last = GetLastOfK(array, k);
        if(first >= 0 && last >= 0){
            return last - first + 1;
        }
        return 0;
    }
}

