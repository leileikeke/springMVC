package com.leike.controller;

import com.leike.pojo.User;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-17 21:02
 */

@Controller
@RequestMapping("/user")
public class UserController2 {

//    @InitBinder
//    public void init(WebDataBinder dataBinder) {
//        //这里指定什么格式 , 前台就只能传什么格式
////        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
//        sdf.setLenient(false);
//        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
//        dataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"),Date.class);
//    }
    // 在controller里面的任意一个处理具体方法之前都会执行
//    @ModelAttribute
//    public User init(){
//        System.out.println("进入init...");
//        User u = new User();
//        u.setName("王菲");
//        return u;
//    }
//    @ModelAttribute
//    public void init(Model model){
//        System.out.println("进入init...");
//        User u = new User();
//        u.setName("王菲");
//        model.addAttribute("user",u);
//    }
    @ModelAttribute
    public void init(Model model){
        System.out.println("进入init...");
        User u = new User();
        u.setName("王菲");
        model.addAttribute("user",u);
    }
    @RequestMapping("/login")
    public String login(@ModelAttribute("user") User user){
        System.out.println(user);
//        System.out.println(model.containsAttribute("u"));
//        System.out.println(model.containsAttribute("user"));
//        System.out.println(model.containsAttribute("2345632"));
        return "/msg";
    }

}
