package com.cqrs.example.command;

import com.cqrs.example.exceptions.ResourceNotFoundException;
import com.cqrs.example.model.Person;
import com.cqrs.example.query.PersonQueryService;
import com.cqrs.example.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonCommandService {

    private static final Logger logger = LoggerFactory.getLogger(PersonCommandService.class);

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonQueryService personQueryService;

    public Person save(Person person){
        logger.info("Save person");
        return personRepository.save(person);
    }

    public Person update(Person person) throws ResourceNotFoundException {
        personQueryService.findById(person.getId());
        logger.info("Save person");
        return personRepository.save(person);
    }

    public void delete(Long id) throws ResourceNotFoundException {
        personQueryService.findById(id);
        logger.info("delete person" + id);
        personRepository.deleteById(id);
    }

}
