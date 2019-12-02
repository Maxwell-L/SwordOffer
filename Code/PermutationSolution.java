/*
 * 字符串的排列
 * 题目描述:
 *     输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母,按字典序打印出该字符串中字符的所有排列。例如输入
 * 字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 思路:
 *     字符串的排列可以看成每次选取一个字符，并和剩余字符的排列组合。利用递归，每次将字符串的一个字符取出，将剩余字符重新拼成
 * 字符串并传入下一步排列的。考虑字符重复，设置一个哈希表存储当前位已经排列过的字符，若该字符在之前已经出现在该位时，跳过该字符。
 */
import java.util.ArrayList;
import java.util.HashMap;

public class PermutationSolution {
    private void helper(ArrayList<String> result, String str, String last) {
        if(str.length() == 0) {
            return;
        }
        if(str.length() == 1) {
            result.add(last.concat(str));
            return;
        }
        HashMap<Character, Boolean> hm = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            if(hm.get(str.charAt(i)) != null) {
                continue;
            }
            hm.put(str.charAt(i), true);
            String newLast = last.concat(str.substring(i, i + 1));
            String newStr = str.substring(0, i).concat(str.substring(i+1, str.length()));
            helper(result, newStr, newLast);
        }
        return;
    }
    
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        helper(result, str, "");
        return result;
    }
}

