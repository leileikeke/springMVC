package com.leike.controller;

import com.leike.pojo.Master;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-19 17:13
 */
@Controller
@RequestMapping("/master")
public class MasterController {

    @RequestMapping("/show")
    public String show(Model model){
        List<Master> list = new ArrayList<>();
        list.add(new Master(0,"唐三藏","110110100"));
        list.add(new Master(1,"大师兄","188888888"));
        list.add(new Master(2,"二师兄","139220020"));
        list.add(new Master(3,"沙和尚","139220020"));
        model.addAttribute("masters",list);
        return "/master/showMaster";
    }

}
