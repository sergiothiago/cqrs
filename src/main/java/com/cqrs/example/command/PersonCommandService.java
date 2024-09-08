package com.cqrs.example.command;

import com.cqrs.example.dto.PersonDTO;
import com.cqrs.example.exceptions.ResourceNotFoundException;
import com.cqrs.example.model.Person;

public interface PersonCommandService {

    public PersonDTO save(PersonDTO personDTO);

    public PersonDTO update(PersonDTO personDTO) throws ResourceNotFoundException;

    public void delete(Long id) throws ResourceNotFoundException;
}
