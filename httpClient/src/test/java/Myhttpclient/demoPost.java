package Myhttpclient;


import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class demoPost {
    private String url;
    //java util包中自带的类，可以读取配置文件,默认识别Properties文件。
    private ResourceBundle bundle;
    //用来存储cookies信息的变量
    private CookieStore store;
    @BeforeTest
    public void beforeTest () {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies () throws IOException {
String result;
//从配置文件中 拼接测试的url
        String uri = bundle.getString("getCookies.uri");
        String testUrl = this.url + uri;

//        测试逻辑代码书写
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);

        //获取cookies信息
        this.store= client.getCookieStore();
        List<Cookie> cookieLise=store.getCookies();
        for(Cookie cookie:cookieLise){
            String  name=cookie.getName();
            String value=cookie.getValue();
            System.out.println("cookie name="+name+";"+"cookies value =" +value);
        }
    }
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostMethod() throws IOException {
String uri=   bundle.getString("test.post.with.Cookies");
//拼接最终的测试地址
        String testUrl = this.url + uri;
        //声明一个client对象，用来进行方法执行
        DefaultHttpClient client=new DefaultHttpClient();

        //声明一个方法，这个方法就是post方法
        HttpPost post=new HttpPost(testUrl);
        //添加参数
        JSONObject param=new JSONObject();
        param.put("name","huhansan");
        param.put("age","18");
        //设置请求头信息,设置header
        post.setHeader("content-type","application/json");
        //将参数信息添加到方法中
        StringEntity entity=new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        //声明一个对象，存储响应
String  result;
        //设置cookies信息
client.setCookieStore(this.store);

        //执行post方法
HttpResponse response=client.execute(post);
        //获取相应结果
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);
        //处理结果，判断返回结果是否符合预期
        //将 返回的响应结果字符串转化为json对象
JSONObject resultJson=new JSONObject(result);
        //具体的判断返回结果的值
      String success=(String)resultJson.get("huhansan");
      String status= (String) resultJson.get("status");
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);
    }
}
