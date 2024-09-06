package com.cqrs.example.query;

import com.cqrs.example.exceptions.ResourceNotFoundException;
import com.cqrs.example.model.Person;
import com.cqrs.example.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonQueryService {

    @Autowired
    private PersonRepository personRepository;

    private static final Logger logger = LoggerFactory.getLogger(PersonQueryService.class);

    public List<Person> findAll(){
        logger.info("Search All");
        return personRepository.findAll();
    }

    public Person findById(Long id) throws ResourceNotFoundException {
        logger.info("FindById");
        return personRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Id " + id + "not found"));
    }

}
