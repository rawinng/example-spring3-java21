package com.rawinn.example.springboot.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.rawinn.example.springboot.data.entity.Person;
import com.rawinn.example.springboot.service.PersonService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

@WebMvcTest(PersonController.class)
@AutoConfigureMockMvc
public class PersonControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private PersonService personService;

        @Test
        public void test_getAllPersons_shouldBeRun_correctly() throws Exception {
                var person = new Person();
                person.setFirstName("Rawin");
                person.setLastName("Ngamloet");
                person.setId(12L);
                var person2 = new Person();
                person2.setFirstName("Suwipha");
                person2.setLastName("Ngamloet");
                person2.setId(12L);
                var list = Arrays.asList(person, person2);
                when(personService.getPersons()).thenReturn(list);

                mockMvc.perform(get("/api/v1/persons"))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$[0].firstName").value("Rawin"))
                                .andExpect(jsonPath("$[0].lastName").value("Ngamloet"))
                                .andExpect(jsonPath("$[1].firstName").value("Suwipha"));

        }

        @Test
        public void test_addPerson_shouldBeRun_correctly() throws Exception {
                var person = new Person();
                person.setFirstName("Rawin");
                person.setLastName("Ngamloet");
                person.setId(12L);

                when(personService.addPerson("Rawin", "Ngamloet")).thenReturn(person);

                var json = """
                                { "firstName":"Rawin",
                                  "lastName":"Ngamloet"
                                }
                                """;

                mockMvc.perform(
                                post("/api/v1/persons")
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .content(json))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.firstName").value("Rawin"));
        }
}
