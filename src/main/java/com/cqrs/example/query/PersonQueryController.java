package com.cqrs.example.query;

import com.cqrs.example.command.PersonCommandService;
import com.cqrs.example.dto.PersonDTO;
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

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/query/persons")
public class PersonQueryController {

    @Autowired
    private PersonQueryService personQueryService;


    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<List<PersonDTO>> findAll() {
        List<PersonDTO> personDTOS = personQueryService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(personDTOS);
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<PersonDTO> findById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        PersonDTO personDTO = personQueryService.findById(id);
        personDTO.add(linkTo(methodOn(PersonQueryController.class).findById(id)).withSelfRel());

        return ResponseEntity.status(HttpStatus.OK).body(personDTO);
    }

}
