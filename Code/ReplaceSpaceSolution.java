/*
 * 替换空格
 * 题目描述: 
 *     请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 思路:
 *     新建一个StringBuffer对象result，遍历字符串，当字符为空格时，result加上"%20"，当字符不是空格时，result加上原来的字符，结果将result转
 * 为String后返回。
 */
public class ReplaceSpaceSolution {
    public String replaceSpace(StringBuffer str) {
    	int i = 0;
        StringBuffer result = new StringBuffer();
        while(i < str.length()){
            if(str.charAt(i) == ' '){
                result.append("%20");
            } else {
                result.append(str.charAt(i));
            }
            i++;
        }
        return result.toString();
    }
}
