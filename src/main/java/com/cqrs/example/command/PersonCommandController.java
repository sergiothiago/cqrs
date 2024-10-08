package com.cqrs.example.command;

import com.cqrs.example.dto.PersonDTO;
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
    public ResponseEntity<PersonDTO> sayHello(@RequestBody PersonDTO personDTO) {
        PersonDTO personDTOSaved = personCommandService.save(personDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(personDTOSaved);
    }

    @PutMapping
    public ResponseEntity<PersonDTO> update(@RequestBody PersonDTO personDTO) throws ResourceNotFoundException {
        PersonDTO personDTOUpdated = personCommandService.update(personDTO);
        return ResponseEntity.status(HttpStatus.OK).body(personDTOUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) throws ResourceNotFoundException {
        personCommandService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
