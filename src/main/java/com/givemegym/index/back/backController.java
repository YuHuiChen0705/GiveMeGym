package com.givemegym.index.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/GiveMeGym")
@Controller
public class backController {

    @GetMapping("/backend/index")
    public String frontIndex(){
        return "backend/back_index";
    }
}