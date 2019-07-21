package com.leike.controller;

import com.leike.pojo.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @description:
 * @author: leike
 * @date: 2019-07-20 14:27
 */
@Controller
@RequestMapping("/json2")
public class JsonController2 {

    @RequestMapping("/add")
    @ResponseBody
    public String add(@RequestBody Order order){
        System.out.println(order);
        return "ok";
    }
    @RequestMapping("/addList")
    @ResponseBody
    public Map<String,Integer> addList(@RequestBody List<Order> orders){
        System.out.println(orders);
        Map<String,Integer> map = new HashMap<>();
        map.put("code",2000);
        return map;
    }
}
