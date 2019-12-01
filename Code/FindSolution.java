/*
 * 二维数组中的查找
 * 题目描述:
 *     在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。 
 *
 * 思路:
 *     从二维数组的右上角开始，如果该数大于target，则可知该列不存在目标值，列数可以减 1。若该数小于target，则可知该行已经不存在
 * 目标值，行数可以加 1。每次测试可以减少一行或一列，直到剩余矩阵右上角元素等于目标值。时间复杂度为 O(m + n)。
 */
public class FindSolution {
    public boolean Find(int target, int [][] array) {
        int row = 0, col = array[0].length - 1;
        while(col >= 0 && row < array.length) {
            if(array[row][col] == target) {
                return true;
            }
            if(array[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}

