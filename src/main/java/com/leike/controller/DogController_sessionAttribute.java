package com.leike.controller;

import com.leike.pojo.Dog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-18 20:54
 */

@Controller
@RequestMapping("/dog")
@SessionAttributes("dog")
public class DogController_sessionAttribute {


    @RequestMapping("register")
    public String register(Dog dog){
        return "dog";
    }
    @RequestMapping("/login")
    public String login(@SessionAttribute Dog dog){

        return "redirect:/jsp/dog.jsp";

    }

}
