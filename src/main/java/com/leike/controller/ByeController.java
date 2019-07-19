package com.leike.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-12 9:19
 */

//不要继承任何的类或者实现任何的接口,不强迫用户
@Controller
public class ByeController {

    @RequestMapping("/bye")
    public String bye(Model model){

        model.addAttribute("model","modeller");

        //这里return就是我们的那个viewName
        //此时去的是 /jsp/bye.jsp页面
        return "bye";

    }

}
