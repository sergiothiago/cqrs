package com.cqrs.example.command;

import com.cqrs.example.dto.PersonDTO;
import com.cqrs.example.exceptions.ResourceNotFoundException;
import com.cqrs.example.mapper.GenericMapper;
import com.cqrs.example.model.Person;
import com.cqrs.example.query.PersonQueryServiceImpl;
import com.cqrs.example.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PersonCommandServiceImpl implements PersonCommandService{

    private static final Logger logger = LoggerFactory.getLogger(PersonCommandServiceImpl.class);

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonQueryServiceImpl personQueryServiceImpl;


    @Transactional
    public PersonDTO save(PersonDTO personDTO){
        logger.info("Save person");

        Person person =
                GenericMapper.parseObject(personDTO, Person.class);

        return GenericMapper.parseObject(personRepository.save(person), PersonDTO.class);
    }

    @Transactional
    public PersonDTO update(PersonDTO personDTO) throws ResourceNotFoundException {
        personQueryServiceImpl.findById(personDTO.getKey());
        Person person =
                GenericMapper.parseObject(personDTO, Person.class);
        logger.info("update person");

        return GenericMapper.parseObject(personRepository.save(person), PersonDTO.class);
    }

    @Transactional
    public void delete(Long id) throws ResourceNotFoundException {
        personQueryServiceImpl.findById(id);
        logger.info("delete person" + id);
        personRepository.deleteById(id);
    }

}
