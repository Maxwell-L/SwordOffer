/* 
 * 左旋转字符串
 * 题目描述:
 *     汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 *
 * 思路:
 *     1、若 str 为空则直接返回 str。
 *     2、n 对字符串长度取余，利用String类中的substring()将字符串分为两部分并用concat()拼接起来。
 */
public class LeftRotateStringSolution {
    public String LeftRotateString(String str,int n) {
        if(str.length() == 0){
            return str;
        }
        n = n % str.length();
        return str.substring(n, str.length()).concat(str.substring(0, n));
    }
} 