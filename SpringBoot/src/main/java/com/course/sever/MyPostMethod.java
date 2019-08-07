package com.course.sever;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@Api(value = "/",description = "这是我全部的post请求")
@RequestMapping("/v1")
public class MyPostMethod {
    //这个变量是用来装我们cookies信息的
    private static Cookie cookie;
    //用户登陆成功获取到cookies，然后再访问其他接口获取到列表
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登陆接口，成功后获取cookies信息", httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName", required = true) String userName,
                        @RequestParam(value = "password", required = true) String password) {
        if (userName.equals("zhangsan") && password.equals("123456")) {
            cookie = new Cookie("login", "true");
            response.addCookie(cookie);
            return "恭喜你登陆成功了!";
        }
        return "用户名或者是密码错误！";
    }

    @RequestMapping(value = "/login2", method = RequestMethod.POST)
    @ApiOperation(value = "登陆接口，成功后获取cookies信息", httpMethod = "POST")
    public String login2(HttpServletResponse response, @RequestBody String param) {
Map<String, Object> a=toStringMap(param);
String username =a.get("username").toString();
        String password =a.get("password").toString();
        if (username.equals("li")&&password.equals("123456")){
            cookie = new Cookie("login", "true");
            response.addCookie(cookie);
            return "恭喜你登录成功";
        }
        return "用户名或密码错误";
    }
    public static Map<String, Object> toStringMap(String json) {
        try {
            return JSON.parseObject(json, Map.class);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
