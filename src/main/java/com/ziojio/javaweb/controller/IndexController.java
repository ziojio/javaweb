package com.ziojio.javaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class IndexController {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("index");
        view.addObject("date", dateFormat.format(new Date()));
        return view;
    }

}
