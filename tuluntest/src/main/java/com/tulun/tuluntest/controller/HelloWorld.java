package com.tulun.tuluntest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by DSB on 2019/7/26
 */
@RestController
@RequestMapping("/hello")
public class HelloWorld {
//    @ResponseBody//给浏览器输出hello
    @RequestMapping(value = "say",method = RequestMethod.GET)//接受服务器hello的请求
    public String say(){
        return "hello!";
    }
}
