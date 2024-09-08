package com.cqrs.example.command;

import com.cqrs.example.exceptions.ResourceNotFoundException;
import com.cqrs.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commands/persons")
public class PersonCommandController {

    @Autowired
    private PersonCommandService personCommandService;

    @PostMapping
    public ResponseEntity<Person> sayHello(@RequestBody Person person) {
        Person personSaved = personCommandService.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(personSaved);
    }

    @PutMapping
    public ResponseEntity<Person> update(@RequestBody Person person) throws ResourceNotFoundException {
        Person personUpdated = personCommandService.update(person);
        return ResponseEntity.status(HttpStatus.OK).body(personUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) throws ResourceNotFoundException {
        personCommandService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
