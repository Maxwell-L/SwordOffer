/*
 * 顺时针打印矩阵
 * 题目描述:
 *     输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 
 * 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
 *
 * 思路:
 *     每次循环打印未打印部分最外一圈数字，按照顺时针顺序，每一圈开始时横纵坐标都是一致的，注意边界判断以及一行、一列的情况。
 * 
 */
import java.util.ArrayList;

public class PrintMatrixSolution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> print = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0) {
            return print;
        }
        int begin = 0, row = matrix.length - 1, col = matrix[0].length - 1;
        while(begin <= row && begin <= col) {
            for(int i = begin; i <= col; i++) {
                print.add(matrix[begin][i]);
            }
            if(begin < row) {
                for(int j = begin + 1; j <= row; j++) {
                    print.add(matrix[j][col]);
                }
            }
            if(begin < col && begin < row) {
                for(int k = col - 1; k >= begin; k--) {
                    print.add(matrix[row][k]);
                }
            }
            if(begin < col && begin < row - 1) {
                for(int l = row - 1; l >= begin + 1; l--) {
                    print.add(matrix[l][begin]);
                }
            }
            begin++;
            row--;
            col--;
        }
        return print;
    }
}
