package String类;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * 字符串在另外一个字符串中出现次数。比如“ab”在“abkkcadkabkebfkabkskab”出现次数
 */
public class 面试题3 {
    public static void main(String[] args) {
        System.out.println(stringCounts("abkkcadkabkebfkabkskab", "ab"));
    }

    public static int stringCounts(String longStr,String shortStr){
        int count = 0;
        for (int i = 0;i<longStr.length()-1;i++){
            if (shortStr.equals(longStr.substring(i,i+2))){
                count ++;
            }
        }
        return count;
    }

    @Test
    //超级漂亮的思路！！！
    public void stringCounts2() {
        // 求“ab”在“abkkcadkabkebfkabkskab”出现次数
        String str1 = "ab", str2 = "abkkcadkabkebfkabkskab";
        String[] split = str2.split("ab");
        System.out.println(Arrays.toString(split));
        System.out.println(split.length);
    }

    // 方法2：用indexOf()
    public int getCount(String mainStr, String subStr) {
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        if (mainLength >= subLength) {
            int count = 0;
            int index;
            while ((index = mainStr.indexOf(subStr)) != -1) {
                count++;
                mainStr = mainStr.substring(index + subLength);
            }
            return count;
        } else
            return 0;
    }
}
