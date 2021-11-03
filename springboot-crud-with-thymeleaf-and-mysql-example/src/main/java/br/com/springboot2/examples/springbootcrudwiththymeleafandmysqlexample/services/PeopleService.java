package br.com.springboot2.examples.springbootcrudwiththymeleafandmysqlexample.services;

import br.com.springboot2.examples.springbootcrudwiththymeleafandmysqlexample.model.People;
import br.com.springboot2.examples.springbootcrudwiththymeleafandmysqlexample.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository repository;

    public List<People> findAll(){
        return repository.findAll();
    }

    public People findById(Long id){
        return repository.findById(id).get();
    }

    public People save(People people){
        people.setRegisteredIn(LocalDateTime.now());
        return repository.save(people);
    }

    public void delete(People people){
        repository.delete(people);
    }

}
