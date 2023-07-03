package com.givemegym.index.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/GiveMeGym")
@Controller
public class frontController {

    @GetMapping("/index")
    public String frontIndex(){
        return "frontend/index";
    }
}
