import org.testng.annotations.Test;

public class timeouttest {

    @Test(timeOut = 3000)//单位为毫秒值
    public void show(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
