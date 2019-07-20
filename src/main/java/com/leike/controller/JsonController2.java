package com.leike.controller;

import com.leike.pojo.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @description:
 * @author: leike
 * @date: 2019-07-20 14:27
 */
@Controller
@RequestMapping("/json2")
public class JsonController2 {

    @RequestMapping("/add")
    public String add(@RequestBody Order order){
        System.out.println(order);
        return "ok";
    }
}
