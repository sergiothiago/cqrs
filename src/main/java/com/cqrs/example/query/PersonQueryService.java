package com.cqrs.example.query;

import com.cqrs.example.exceptions.ResourceNotFoundException;
import com.cqrs.example.model.Person;

import java.util.List;

public interface PersonQueryService {

    public List<Person> findAll();

    public Person findById(Long id) throws ResourceNotFoundException;
}
