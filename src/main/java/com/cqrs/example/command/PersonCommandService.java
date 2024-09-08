package com.cqrs.example.command;

import com.cqrs.example.exceptions.ResourceNotFoundException;
import com.cqrs.example.model.Person;

public interface PersonCommandService {

    public Person save(Person person);

    public Person update(Person person) throws ResourceNotFoundException;

    public void delete(Long id) throws ResourceNotFoundException;
}
