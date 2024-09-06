package com.cqrs.example.command;

import com.cqrs.example.exceptions.ResourceNotFoundException;
import com.cqrs.example.model.Person;
import com.cqrs.example.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonCommandService {

    @Autowired
    private PersonRepository personRepository;

    private static final Logger logger = LoggerFactory.getLogger(PersonCommandService.class);

//    public Person save(Person person){
//        logger.info("Search All");
//        return personRepository.findAll();
//    }

}
