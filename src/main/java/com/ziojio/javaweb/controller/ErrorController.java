package com.ziojio.javaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

    @GetMapping("/404")
    public ModelAndView error() {
        return new ModelAndView("404");
    }

}
