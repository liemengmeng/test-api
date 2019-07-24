import org.testng.annotations.Test;

public class duoxiancheng {
    @Test(invocationCount = 10,threadPoolSize = 3)
    public  void show(){
        System.out.println("1");
        System.out.print("Thread id : "+Thread.currentThread().getId());
    }
}
