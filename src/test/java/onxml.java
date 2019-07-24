import org.testng.annotations.Test;



public class onxml {
    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test(){
        int a=1;
        System.out.println(a);
        System.out.print("Thread id ="+a+"="+Thread.currentThread().getId());
    }
}
