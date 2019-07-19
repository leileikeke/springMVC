package com.leike.controller;

import com.leike.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-18 22:40
 */
@Controller
@RequestMapping("/cookie")
public class CookieController {

    @ModelAttribute
    public void init(Model model){
        model.addAttribute("user",new User("王菲","2333",new Date()));
    }
    @RequestMapping("/c1")
    public String c(@CookieValue("JSESSIONID") String jsessionid,@ModelAttribute("user") User user){
        System.out.println(jsessionid);
        return "msg";
    }

}
