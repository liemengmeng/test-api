package Myhttpclient;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.DefaultHttpClient;

import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class demo1 {
    @Test
    public void test1() {
        //用来存放结果
        String result;
        HttpGet get =new HttpGet("http://www.baidu.com");
        //用来执行get方法
        HttpClient client=new DefaultHttpClient();
        try {
        HttpResponse response=client.execute(get);
        //获取整个response返回的全部内容并转换为String类型放到结果中
            result=   EntityUtils.toString(response.getEntity(),"UTF-8")   ;
         System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}