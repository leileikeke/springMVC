package com.leike.controller;

import com.leike.pojo.User;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-17 21:02
 */

@Controller
@RequestMapping("/user")
public class UserController {

//    @InitBinder
//    public void init(WebDataBinder dataBinder) {
//        //这里指定什么格式 , 前台就只能传什么格式
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
//        sdf.setLenient(false);
//        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
//
//    }

    @PutMapping("/put")
    //需要额外的json包支持
    @ResponseBody
    public String put(@RequestParam("name") String name, @RequestParam("password") String psword) {

        System.out.println(name + "   " + psword);
//        Map<String, String> map = new HashMap<>();
//        map.put("msg","ok");

        return "ok";
    }

    @PutMapping("/put1")
    //需要额外的json包支持
    @ResponseBody
    public String put(User user) {

        System.out.println(user);
//        Map<String, String> map = new HashMap<>();
//        map.put("msg","ok");
        return "ok";
    }

    @PutMapping("/put2")
    //需要额外的json包支持
    @ResponseBody
    public String put2(User user) {

//        System.out.println(name + "  " + password + "  " + birthday);
        System.out.println(user);
//        Map<String, String> map = new HashMap<>();
//        map.put("msg","ok");
        return "ok";
    }
}
