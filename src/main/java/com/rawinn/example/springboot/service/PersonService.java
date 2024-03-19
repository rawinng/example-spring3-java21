package com.rawinn.example.springboot.service;

import java.util.List;

import com.rawinn.example.springboot.data.entity.Person;

public interface PersonService {

    public Person getPersonById(Long id);

    public Person addPerson(String firstName, String lastName);

    public List<Person> getPersons();
}
