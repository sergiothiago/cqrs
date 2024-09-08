package com.cqrs.example.query;

import com.cqrs.example.dto.PersonDTO;
import com.cqrs.example.exceptions.ResourceNotFoundException;
import com.cqrs.example.mapper.GenericMapper;
import com.cqrs.example.model.Person;
import com.cqrs.example.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PersonQueryServiceImpl implements PersonQueryService {

    @Autowired
    private PersonRepository personRepository;

    private static final Logger logger = LoggerFactory.getLogger(PersonQueryServiceImpl.class);

    public List<PersonDTO> findAll(){
        logger.info("Search All");

        List<Person> persons = personRepository.findAll();

        List<PersonDTO> personDTOS = persons.stream().map((person) ->
                        GenericMapper.parseObject(person, PersonDTO.class)).collect(Collectors.toList());

        return personDTOS;
    }

    public PersonDTO findById(Long id) throws ResourceNotFoundException {
        logger.info("FindById");
        Person person = personRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Id " + id + "not found"));

        return GenericMapper.parseObject(person, PersonDTO.class);
    }

}
