package String类;

import org.testng.annotations.Test;

/**
 * 获取两个字符串中最大的相同子串。如：str1=“abcwerthlloyuiodef”,str2=“cvhellobnm”
 */
public class 面试题4 {
    public static void main(String[] args) {
        //System.out.println(getSame("abcwerthlloyuiodef","cvhellobnm"));
        getSame("abcwerthlloyuiodef","cvhellobnm");
    }



    //逐步截取出字符串所有字串的完美操作！！！！！！！！！！！
    @Test
    public void test1(){
        String s1 = "ascd";
        for (int i = 0; i <s1.length() ; i++) {
            for (int j=0,k=s1.length()-i;k<s1.length()+1;j++,k++){
                System.out.println(s1.substring(j,k));
            }
        }
        /*
        ascd
        asc
        scd
        as
        sc
        cd
        a
        s
        c
        d
         */
    }

    public static void getSame(String str1,String str2){
        String str_long = (str1.length() > str2.length())?str1:str2;
        String str_short = (str1.length() < str2.length())?str1:str2;
        int num = 0;
        for (int i = 1; i <str_short.length() ; i++) {
            for (int j = 0,k = str_short.length()-i;k<str_short.length()+1;j++,k++){
                String s = str_short.substring(j, k);
                boolean flag = str_long.contains(s);
                if (flag && s.length() > num){
                    num =  s.length();
                    System.out.println("num:"+num);
                    System.out.println("s:"+s);
                }
            }
        }
    }
    @Test
    public void test4() {
        String str1 = "abcwerthelloyuiodef",str2 = "cvhellobnm";
        String str0 = (str1.length() > str2.length()) ? str2 : str1;
        String str = (str1.length() > str2.length()) ? str1 : str2;
        int num = 0;
        for (int i = 0; i < str0.length(); i++) {
            //可以理解为i控制剩余长度，j、k改变子字符串里面的字符但是长度不变依次与str1比较，
            //当第一次满足条件输出结果时，得到的就是最大相同字串
            for (int j = 0,k=str0.length() - i; k<str0.length(); j++,k++) {
                String string = str0.substring(j,k);
                boolean contains = str1.contains(string);
                //如test5中所写，这里一旦为true就可以直接中断了。因为字串从最大的循环起！！
                if (contains && string.length() > num) {
                    num = string.length();
                    System.out.println(string);
                    System.out.println(string.length());
                }
            }
        }
    }

    @Test
    public void test5(){
        String s1 = "abcwerthelloyuiodef",s2 = "z111111";
        String s_long,s_short;

        s_long = s1.length() > s2.length() ? s1 : s2;
        s_short = s1.length() > s2.length() ? s2 : s1;
        int num = 0;
        for (int i = 0; i <s_short.length() ; i++) {
            for (int j=0,k=s_short.length()-i;k<s_short.length()+1;k++,j++){
                String s = s_short.substring(j, k);
                if (s_long.contains(s)){
                    num = s.length();
                    System.out.println(s);
                    System.out.println(num);
                }
            }
            break;
        }
    }
}
