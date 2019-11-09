/*
 * 数值的整数次方
 * 题目描述:
 *     给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *     保证base和exponent不同时为0。
 *
 * 思路:
 *     先判断指数正负，用一个 flag 记录，转为正数，将指数按照二进制来计算，2.5^13 = 2.5^(1101)B = 2.5^(1000)B * 2.5^(100)B * 2.5^1。从低位到高位，
 * 每次循环将exponent右移 1 位，判断该位是否为 1，若为将当前基数乘到结果上，每次循环将基数翻倍。循环结束后若 flag 为 false 将结果转为倒数。
 */
public class PowerSolution {
    public double Power(double base, int exponent) {
        double result = 1;
        boolean flag = exponent >= 0 ? true : false;
        exponent = flag ? exponent : -1 * exponent;
        while(exponent != 0){
            if((exponent & 1) == 1) {
                result *= base;
            }
            base *= base;
            exponent >>>= 1;
        }
        return flag ? result : 1.0 / result;
  }
}
