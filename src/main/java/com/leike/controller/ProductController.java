package com.leike.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-17 15:24
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("/add/{id}/{name}/{price}")
    public String addProduct(@PathVariable("id") Integer id,
                             @PathVariable("name") String name,
                             @PathVariable("price") Double price){

        System.out.println("id:" +id+
                "name:" +name+
                "price:"+price);
        return "/forword";

    }
}
