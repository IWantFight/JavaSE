package String类;

import org.testng.annotations.Test;

import java.util.Arrays;

/*
对字符串中字符进行自然顺序排序
 */
public class 面试题5 {
    @Test
    public void run(){
        String s1 = "kfuwmsnfiowfpadrgfe";
        char[] chars = s1.toCharArray();
        System.out.println(chars);
        Arrays.sort(chars);
        System.out.println(chars);
    }
}
