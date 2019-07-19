package com.leike.controller;

import com.leike.pojo.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-12 9:55
 */

@Controller
@RequestMapping("/orders")
public class OrderController {

    @RequestMapping("/addOrder")
    //这里的返回值为String,String就是逻辑的视图名称
    public String orderAdd(Model model){

        List<Order> orders = new ArrayList<>();

        Order order = new Order("1","平底锅",2432.1);
        Order order2 = new Order("2","大锄头",3306.0);

        orders.add(order);
        orders.add(order2);
        model.addAttribute("orders",orders);

        return "order";
    }
}
