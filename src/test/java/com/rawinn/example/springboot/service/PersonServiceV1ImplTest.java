package com.rawinn.example.springboot.service;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.rawinn.example.springboot.data.entity.Person;
import com.rawinn.example.springboot.data.repo.PersonRepository;
import static org.mockito.ArgumentMatchers.any;

/**
 * Test class for PersonServiceV1Impl
 */
@SpringBootTest(classes = PersonServiceV1Impl.class)
public class PersonServiceV1ImplTest {

    @Autowired
    private PersonServiceV1Impl personServiceV1Impl;

    @MockBean
    private PersonRepository personRepository;

    @Test
    public void test_addPerson_shouldBeRun_correctly() {
        personServiceV1Impl.addPerson("Rawin", "Ngamloet");
        verify(personRepository).save(any(Person.class));
    }
}
