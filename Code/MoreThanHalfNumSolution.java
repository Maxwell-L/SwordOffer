/*
 * 数组中出现次数超过一半的数字
 * 题目描述:
 *     数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * 思路:
 *     遍历数组时保存两个值，一个为数字，一个为次数。当数组的当前数字与保存的数字不同时，次数减一，相同时加一，次数为0时将保存的
 * 数字改成当前数字并将次数赋为1。遍历结束后，若数组存在次数超过一半的数字，那只能是保存的数字，再遍历一次进行验证即可得到答案。
 */
public class MoreThanHalfNumSolution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0) {
            return 0;
        }
        int value = array[0], time = 1, check = 0;
        for(int i = 1; i < array.length; i++) {
            if(array[i] == value){
                time++;
            } else if(time != 0){
                time--;
            } else {
                value = array[i];
                time++;
            }
        }
        for(int i = 0; i < array.length; i++){
            if(array[i] == value) {
                check++;
            }
        }
        return check * 2 > array.length ? value : 0;
    }
}

