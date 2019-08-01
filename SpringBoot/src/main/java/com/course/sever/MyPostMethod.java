package com.course.sever;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "/",description = "这是我全部的post方法" )
@RequestMapping("/v1")
public class MyPostMethod {

}
