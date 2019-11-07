/*
 * 数组中只出现一次的数字
 * 题目描述:
 *     一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * 思路:
 *     1、将数组中的元素全部异或，相同的数字异或为0，最后结果是两个只出现一次的数字的异或。
 *     2、由于两个数不同，故它们的异或至少有一位为 1，记录当两数异或偏移量为offset时该位为1，再次遍历数组，按照右移offset位后最后一位是0还是1
 *     分成两部分，分别与第1步的结果异或，即可分别得出两个数。
 */
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class FindNumsAppearOnceSolution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        num1[0] = 0; 
        num2[0] = 0;
        for(int i = 0; i < array.length; i++){
            num1[0] ^= array[i];
        }
        num2[0] = num1[0];
        int offset = 0;
        while(((num1[0] >> offset) & 1) == 0){
            offset++;
        }
        for(int i = 0; i < array.length; i++){
            if(((array[i] >> offset) & 1) == 0){
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }
}
