package com.leike.controller;

import com.leike.pojo.Order;
import com.leike.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-20 14:27
 */
//@Controller
@RestController // == @Controller+@ResponseBody  当整个Controller都是用于返回json的时候使用
@RequestMapping("/json")
public class JsonController {

    @RequestMapping("/m1")
//    @ResponseBody
    public Order m1() {

        Order order = new Order("1", "leike", 12.3);

        return order;
    }

    @RequestMapping("/m2")
//    @ResponseBody
    public Map<String, Object> m2() {

        Map<String, Object> map = new HashMap<>();
        Order order = new Order("1", "lk", 12.3);
        Order order1 = new Order("2", "lk2", 12.3);
        Order order2 = new Order("3", "lk3", 12.3);

        map.put("1", order);
        map.put("2", order1);
        map.put("3", order2);

        return map;
    }

    @RequestMapping("/m3")
//    @ResponseBody
    public List<Order> m3() {

        List<Order> list = new ArrayList<>();
        Order order = new Order("1", "lk", 12.3);
        Order order1 = new Order("2", "lk2", 12.3);
        Order order2 = new Order("3", "lk3", 12.3);

        list.add(order);
        list.add(order1);
        list.add(order2);
        return list;
    }

    @RequestMapping("/m4")
//    @ResponseBody
    public Order[] m4() {

        Order[] list = {new Order("1", "lk", 12.3),
                new Order("2", "lk2", 12.3),
                new Order("3", "lk3", 12.3)};

        return list;
    }

}
