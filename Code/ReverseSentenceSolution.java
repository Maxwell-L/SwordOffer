/*
 * 翻转单词顺序列
 * 题目描述:
 *     牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
 * 但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 * 思路:
 *     利用 split() 将输入的字符串按照空格分割成字符串数组，如果字符串输入没有单词，则数组为空，直接返回原字符串，否则将字符串数组翻转，转为
 * List<String>类型，再利用 join() 函数将数组中的每个单词用空格拼接成字符串。
 */
import java.util.*;

public class ReverseSentenceSolution {
    public String ReverseSentence(String str) {
        String[] words = str.split(" ");
        if(words.length == 0) {
            return str;
        }
        int left = 0, right = words.length - 1;
        while(left < right){
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        List<String> wordList = Arrays.asList(words);
        return String.join(" ", wordList);
    }
}
