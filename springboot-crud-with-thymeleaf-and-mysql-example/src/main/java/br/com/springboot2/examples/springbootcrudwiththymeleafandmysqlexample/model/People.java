package br.com.springboot2.examples.springbootcrudwiththymeleafandmysqlexample.model;

import br.com.springboot2.examples.springbootcrudwiththymeleafandmysqlexample.enums.Genre;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Entity
@Table(name = "people")
public class People implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String firstName;
    private String lastName;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "birth_data", nullable = false)
    private LocalDate birthDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime registeredIn;
    @Enumerated(EnumType.STRING)
    @Column(name = "genre", length = 1)
    private Genre genre;

    @Transient
    private Integer age;

    public Integer getAge() {
        age = Period.between(this.birthDate, LocalDate.now()).getYears();
        return age;
    }

    public People() {
    }

    public People(Long id, String firstName, String lastName, LocalDate birthDate, LocalDateTime registeredIn, Genre genre) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.registeredIn = registeredIn;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDateTime getRegisteredIn() {
        return registeredIn;
    }

    public void setRegisteredIn(LocalDateTime registeredIn) {
        this.registeredIn = registeredIn;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
