package br.com.springboot2.examples.springbootcrudwiththymeleafandmysqlexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping
    public String getIndex(){
        return "redirect:/people";
    }
}
