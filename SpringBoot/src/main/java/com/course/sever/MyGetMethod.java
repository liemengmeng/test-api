package com.course.sever;
        import io.swagger.annotations.Api;
        import io.swagger.annotations.ApiOperation;
        import org.springframework.web.bind.annotation.*;
        import javax.servlet.http.Cookie;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.util.HashMap;
        import java.util.Map;
        import java.util.Objects;

@RestController//代表被扫描的类
@Api(value = "/",description = "这是我全部的get方法" )
public class MyGetMethod {
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    @ApiOperation(value="通过这个方法可以获取到cookies",httpMethod = "GET")
    public String getCookies(HttpServletResponse response){
        //HttpServletRequest   装请求信息的类
        //HttpServletResponse  装响应信息的类
        Cookie cookie = new Cookie("login","true");
        //加入cookies信息
        response.addCookie(cookie);
        return "恭喜你获得cookies信息成功";
    }

    /**
     * 要求客户端携带cookies访问
     */
    @RequestMapping(value = "/getWithCookies",method = RequestMethod.GET)
    @ApiOperation(value="要求客户端携带cookies访问",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest  request){
        Cookie[] cookies=request.getCookies();
        if(Objects.isNull(cookies)){
            return "你必须携带cookies信息";
        }
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("login")&&cookie.getValue().equals("true")){
                return "恭喜访问成功";
            }
        }
return  "你必须携带一个cookies信息";
    }
       /**
     * 开发一个需要携带参数才能访问的get请求
     * 第一种实现方式url：key=value&key=value
     * 我们来模拟获取商品列表
     */
    @RequestMapping(value = "/getWithParam",method = RequestMethod.GET )
    @ApiOperation(value="开发一个需要携带参数才能访问的get请求",httpMethod = "GET")
    public Map<String,Integer>getList(@RequestParam Integer start,@RequestParam Integer end){
        Map<String,Integer> mylist=new HashMap<>();
        mylist.put("鞋",100);
        mylist.put("干脆面",1);
        mylist.put("衬衫",300);
        return  mylist;
    }

    /**
     * 第二种需要写的带单数访问的get请求
     * url：ip：port/getWithparam/10/20
     */
@RequestMapping(value = "/getWithParam/{start}/{end}")
@ApiOperation(value="第二种需要写的带单数访问的get请求",httpMethod = "GET")
    public Map myGetList(@PathVariable Integer start,@PathVariable Integer end){
        Map<String,Integer> mylist=new HashMap<>();
        mylist.put("鞋",100);
        mylist.put("干脆面",1);
        mylist.put("衬衫",300);
        return  mylist;
    }
}
