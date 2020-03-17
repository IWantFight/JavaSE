package String类;

import org.testng.annotations.Test;

import java.util.Arrays;


/*
    实现了Serializable接口，
 */
public class Demo1 {
    @Test
    public void run(){
        String s = "helloworld";
        int hello = s.indexOf("ello");
        System.out.println(hello);
    }

    @Test
    public void run2(){
        String s = "hello中国";
        byte[] bytes = s.getBytes();
        System.out.println(Arrays.toString(bytes));
        String s1 = Arrays.toString(bytes);
        String[] split = s1.split(",");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);

        }
    }
}


