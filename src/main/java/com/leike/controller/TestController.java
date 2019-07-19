package com.leike.controller;

import com.leike.pojo.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-12 15:25
 * 自测
 */
@Controller
@RequestMapping("/test")
public class TestController {


    @RequestMapping("/addtest")
    public String addtest(Model model){
        List<Order> lists = new ArrayList<>();
        //定义一个随机数生成器
        Random random = new Random();
        /**
         *  random.nextInt(x)随机生成一个[0,x)之间的int
         */
        for (int i=0;i<10;i++){
            //生成一个[100,1000)的double
            double price = (random.nextInt(90000)+10000)*0.01;
            lists.add(new Order(i+"","小花"+i+"号",price));
        }
        model.addAttribute("lists",lists);

        return "/testjsp";

    }


    /**
     *  重定向到WebElementController控制器下面的web/request下面  并且发送一个request请求
     */
    @RequestMapping("/request")
    public String webrequest(Model model){

        model.addAttribute("boy","boytest");

        return "redirect:/web/request";
    }

    /**
     *
     */
    @RequestMapping("/request2")
    public String webrequest1(Model model){

        model.addAttribute("boy","forward:boy");
        return "forward:/web/request2?boy=boytestCon";
    }

}
