package br.com.springboot2.examples.springbootcrudwiththymeleafandmysqlexample.controller;

import br.com.springboot2.examples.springbootcrudwiththymeleafandmysqlexample.enums.Genre;
import br.com.springboot2.examples.springbootcrudwiththymeleafandmysqlexample.model.People;
import br.com.springboot2.examples.springbootcrudwiththymeleafandmysqlexample.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PeopleService service;

    @GetMapping("")
    public String getPeoples(Model model){
        model.addAttribute("peoples", service.findAll());
        return "peoples";
    }

    @GetMapping("/new")
    public String insertPeople(People people){
        return "people";
    }

    @GetMapping("/id/{id}")
    public String getPeople(@PathVariable("id") Long id, Model model){
        model.addAttribute("people", service.findById(id));
        return "people";
    }

    @GetMapping("/delete/id/{id}")
    public String delete(@PathVariable("id") Long id){
        People people = service.findById(id);
        service.delete(people);
        return "redirect:/people";
    }

    @PostMapping
    public String save(People people){
        service.save(people);
        return "redirect:/people";
    }

    @ModelAttribute("genres")
    public Genre[] getGenres(){
        return Genre.values();
    }
}
