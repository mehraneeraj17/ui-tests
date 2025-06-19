package example;

import org.testng.annotations.Test;


public class FirstTest extends BaseTest {

    @Test
    public void test1() {
        getDriver().get("https://www.google.com");
        System.out.println("Test1.1");
    }

//    @Test
//    public void test2() {
//        getDriver().get("https://www.gmail.com");
//        System.out.println("Test1.2");
//    }
}
