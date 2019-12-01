/*
 * 不用加减乘除做加法
 * 题目描述:
 *     写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * 思路:
 *     考虑位运算，每一位计算时要考虑两个数的当前位和进位，假设事件A、B、C分别为num1当前位为1，num2当前位为1，进位carry为1，列出
 * 真值表，并用布尔代数进行计算，可得两数和的当前位为 A ^ (B ^ C)，下一位的进位carry为 A(B ^ C) + BC。由于计算从末位开始，用一个栈
 * 存储每次计算的值，当两数移位至0且进位为0时，将其依次取出并组合成结果。
 */
import java.util.Stack;

public class AddSolution {
    public int Add(int num1,int num2) {
        int carry = 0, result = 0;
        Stack<Integer> stack = new Stack<>();
        while(carry != 0 || num1 != 0 || num2 != 0) {
            stack.push((num1 & 1) ^ ((num2 & 1) ^ carry));
            carry = ((num1 & 1) & ((num2 & 1) ^ carry)) | ((num2 & 1) & carry);
            num1 >>>= 1;
            num2 >>>= 1;
        }
        while(!stack.empty()) {
            result = (result << 1) | stack.pop();
        }
        return result;
    }
}

