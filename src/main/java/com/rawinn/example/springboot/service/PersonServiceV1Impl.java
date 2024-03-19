package com.rawinn.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.stereotype.Service;

import com.rawinn.example.springboot.data.entity.Person;
import com.rawinn.example.springboot.data.repo.PersonRepository;

@Service
public class PersonServiceV1Impl implements PersonService {

    private PersonRepository personRepository;

    @ConstructorBinding
    public PersonServiceV1Impl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public Person addPerson(String firstName, String lastName) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        return personRepository.save(person);
    }

    @Override
    public List<Person> getPersons() {
        return personRepository.findAll();
    }
}
