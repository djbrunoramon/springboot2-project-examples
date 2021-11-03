package br.com.springboot2.examples.springbootcrudwiththymeleafandmysqlexample.repository;

import br.com.springboot2.examples.springbootcrudwiththymeleafandmysqlexample.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {
}
