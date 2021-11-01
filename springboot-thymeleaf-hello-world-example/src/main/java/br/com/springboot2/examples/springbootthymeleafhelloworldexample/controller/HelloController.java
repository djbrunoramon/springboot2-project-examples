package br.com.springboot2.examples.springbootthymeleafhelloworldexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping
    public String getPageHello(){
        return "page-hello";
    }
}
