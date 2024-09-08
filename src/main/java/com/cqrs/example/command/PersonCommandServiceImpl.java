package com.cqrs.example.command;

import com.cqrs.example.exceptions.ResourceNotFoundException;
import com.cqrs.example.model.Person;
import com.cqrs.example.query.PersonQueryServiceImpl;
import com.cqrs.example.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonCommandServiceImpl implements PersonCommandService{

    private static final Logger logger = LoggerFactory.getLogger(PersonCommandServiceImpl.class);

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonQueryServiceImpl personQueryServiceImpl;

    public Person save(Person person){
        logger.info("Save person");
        return personRepository.save(person);
    }

    public Person update(Person person) throws ResourceNotFoundException {
        personQueryServiceImpl.findById(person.getId());
        logger.info("Save person");
        return personRepository.save(person);
    }

    public void delete(Long id) throws ResourceNotFoundException {
        personQueryServiceImpl.findById(id);
        logger.info("delete person" + id);
        personRepository.deleteById(id);
    }

}
