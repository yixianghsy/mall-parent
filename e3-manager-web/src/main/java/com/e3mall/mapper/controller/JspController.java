package com.e3mall.mapper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class JspController {
            @GetMapping("hello")
            //不用加后缀，在配置文件里面已经指定了后缀
            public String index(){
                return "index";
            }
        }



