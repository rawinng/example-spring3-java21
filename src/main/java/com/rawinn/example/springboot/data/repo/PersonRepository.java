package com.rawinn.example.springboot.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rawinn.example.springboot.data.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
