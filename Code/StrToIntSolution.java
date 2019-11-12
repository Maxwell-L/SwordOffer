/*
 * 把字符串转换成整数
 * 题目描述:
 *     将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。数值为0或者字符串不是一个合法的数值则返回0。
 *
 * 思路:
 *     1、如果字符串为空，直接返回0。
 *     2、判断第一个字符是否有符号，正数flag为true，负数flag为false。
 *     3、从非符号开始遍历字符串，如果不是数字直接返回0，否则根据flag决定是加或减去当前数字。
 *     4、若flag为真，则result > 0必然为真，若不为真说明数值溢出，此时 flag ^ (result > 0)为真。同理，若flag为假，则result < 0 必然
 *     为真，若不为真说明数值溢出，此时result > 0，故 flag ^ (result > 0)为真；可得当 flag 与 result > 0 异或为真时数值溢出，直接返回0。
 */
public class StrToIntSolution {
    public int StrToInt(String str) {
        if(str.length() == 0) {
            return 0;
        }
        int result = 0, i = 0;
		boolean flag = true;
        switch(str.charAt(0)){
            case '+':
                i++;
                break;
            case '-':
                flag = false;
                i++;
                break;
        }
        for(;i < str.length(); i++) {
            if(str.charAt(i) < '0' || str.charAt(i) > '9') {
                return 0;
            }
			if(flag){
				result = result * 10 + (str.charAt(i) - '0');
			} else {
				result = result * 10 - (str.charAt(i) - '0');
			}
			if(flag ^ (result > 0)){
				return 0;
			}
        }
        return result;
    }
}
