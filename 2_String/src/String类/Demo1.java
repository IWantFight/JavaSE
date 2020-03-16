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

}
