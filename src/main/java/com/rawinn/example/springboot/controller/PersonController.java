package com.rawinn.example.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rawinn.example.springboot.data.entity.Person;
import com.rawinn.example.springboot.service.PersonService;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> list() {
        return personService.getPersons();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person add(@RequestBody Person person) {
        return personService.addPerson(person.getFirstName(), person.getLastName());
    }

    @GetMapping("{id}")
    public Person getItem(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

}
