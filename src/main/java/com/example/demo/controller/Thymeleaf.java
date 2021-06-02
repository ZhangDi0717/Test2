package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class Thymeleaf {

    @RequestMapping(value = "/show")
    public String show(Model model){
        model.addAttribute("uid","123456");
        model.addAttribute("name","张三");
        model.addAttribute("link","http://baidu.com");

        return "show";
    }

    @RequestMapping(value = "/getdata")
    public @ResponseBody String  getdata(){

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
//        System.out.println(formatter.format(date));
        return formatter.format(date);
    }
}
