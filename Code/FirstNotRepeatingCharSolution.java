/*
 * 第一个只出现一次的字符
 * 题目描述:
 *     在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 
 * 如果没有则返回 -1（需要区分大小写）。
 *
 * 思路:
 *     用一个数组实现哈希表，第一次遍历字符串时以字符的ASCII码作为数组下标，出现次数作为值存储，第二次遍历字符串
 * 时检测当前字符出现次数是否为1，若为1返回当前位置；遍历结束后若仍未返回说明没有只出现一次的字符，返回-1。
 */
public class FirstNotRepeatingCharSolution {
    public int FirstNotRepeatingChar(String str) {
        int[] ascii = new int[128];
        for(int i = 0; i < str.length(); i++) {
            int index = (int)str.charAt(i);
            ascii[index]++;
        }
        for(int i = 0; i < str.length(); i++) {
            if(ascii[(int)str.charAt(i)] == 1){
                return i;
            }
        }
        return -1;
    }
}

