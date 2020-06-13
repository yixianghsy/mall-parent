package com.e3mall.mapper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description
 * @Author sgl
 * @Date 2018-05-08 10:47
 */
@Controller
public class IndexController {

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("index");
        view.addObject("userName", "哈哈哈哈哈");
        return view;
    }
}
