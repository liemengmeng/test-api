import org.testng.annotations.*;

public class suite {
    @BeforeSuite
    public void  BeforeSuite(){
        System.out.println("BeforeSuite");
    }
    @BeforeTest
    public void  BeforeTest(){
        System.out.println("BeforeTest");
    }
    @BeforeClass
    public void  BeforeClass(){
        System.out.println("BeforeClass");
    }
    @BeforeMethod
    public void  BeforeMethod(){
        System.out.println("BeforeMethod");
    }
   @ BeforeGroups("clienr")
    public void    BeforeGroups(){
        System.out.println("BeforeGroups");
    }
    @Test
    public void test1(){
        System.out.println("test1");
    }
    @Test(groups="clienr")
    public void test3(){
        System.out.println("test3");
    }
    @Test
    public void test2(){
        System.out.println("test2");
    }
    @ AfterGroups("clienr")
    public void    AfterGroups(){
        System.out.println(" AfterGroups");
    }
    @AfterMethod
    public void AfterMethod(){
        System.out.println("AfterMethod");
    }
    @AfterClass
    public void AfterClass(){
        System.out.println("AfterClass");
    }
    @AfterTest
    public void AfterTest(){
        System.out.println("AfterTest");
    }

    @AfterSuite
    public void  AfterSuite(){
        System.out.println("BAfterSuite");
    }

}
