package String类;

import java.util.Arrays;

/**
 * 模拟一个trim方法，去掉字符串两端空格
 */
public class 面试题1 {
    public static void main(String[] args) {
        System.out.println(myStrim1("       h "));
        System.out.println(myStrim2("       h "));

    }

    //分别剥掉头尾空格，再用substring方法！
    public static String myStrim1(String s){
        int start = 0;
        int end = s.length()-1;
        while (start<end && s.charAt(start) == ' '){
            start ++;
        }
        while (end > start && s.charAt(end) == ' '){
            end --;
        }
        return s.substring(start,end+1);
    }

    //思想一致，只不过将string转换为数组进行索引比较，上面的是采用charAt方法进行索引比较
    public static String myStrim2(String s){
        int start = 0;
        int end = s.length()-1;
        char[] s_chars = s.toCharArray();
        for (int i = 0; i <s_chars.length; i++) {
            if (s_chars[i] == ' '){
                start++;
            }else{
                break;
            }
        }
        for (int i = s_chars.length-1; i >0; i--) {
            if (s_chars[i] == ' '){
                end--;
            }else{
                break;
            }
        }
        return s.substring(start,end+1);
    }
}
