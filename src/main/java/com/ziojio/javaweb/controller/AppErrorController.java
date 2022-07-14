package com.ziojio.javaweb.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppErrorController implements ErrorController {

    @RequestMapping("/error")
    public ModelAndView error() {
        return new ModelAndView("error");
    }

    @RequestMapping("/404")
    public ModelAndView notFound() {
        return new ModelAndView("404");
    }

}
