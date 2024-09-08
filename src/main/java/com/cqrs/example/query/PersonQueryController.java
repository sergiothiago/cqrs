package com.cqrs.example.query;

import com.cqrs.example.command.PersonCommandService;
import com.cqrs.example.exceptions.ResourceNotFoundException;
import com.cqrs.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/query/persons")
public class PersonQueryController {

    @Autowired
    private PersonQueryService personQueryService;


    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<List<Person>> findAll() {
        List<Person> persons = personQueryService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(persons);
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<Person> findAll(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Person person = personQueryService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

}
