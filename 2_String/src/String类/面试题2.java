package String类;

/**
 *将一个字符串指定部分反转 。比如 “ab cdef cdefg”反转为 ”ab fedc fedc g”
 */
public class 面试题2 {
    public static void main(String[] args) {
        System.out.println(getReverse1("hhudench", 3, 7));
        System.out.println(getReverse2("hhudench", 3, 7));
        System.out.println(getReverse2("hhudench", 3, 7));
    }


    //该方法将String转为char型数组，在循环颠倒
    public static String getReverse1(String s,int start, int end){
        char[] s_chars = s.toCharArray();
        char temp = ' ';
        for (int x = start-1,y=end-1;x<y;x++,y--) {
            temp = s_chars[x];
            s_chars[x] = s_chars[y];
            s_chars[y] = temp;
        }
        return new String(s_chars);
    }

    //使用Strin拼接，效率低
    public static String getReverse3(String s,int start, int end){
        String s1 = s.substring(0,start-1);
        for (int i = end-1;i>=start-1;i++){
            s1 += s.charAt(i);
        }
        s1 += s.substring(end,s.length());
        return s1;
    }

    //使用Stringbuilder进行优化
    public static String getReverse2(String s,int start, int end){
        StringBuilder sb = new StringBuilder();
        char[] s_chars = s.toCharArray();
        sb.append(s.substring(0,start-1));
        for (int i=end-1; i >=start-1; i--) {
            sb.append(s_chars[i]);
        }
        sb.append(s.substring(end,s.length()));
        return sb.toString();
    }
}
