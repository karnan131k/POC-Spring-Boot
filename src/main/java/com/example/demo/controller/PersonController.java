package com.example.demo.controller;

import com.example.demo.dto.PersonRequestDTO;
import com.example.demo.dto.PersonResponseDTO;
import com.example.demo.person.PersonEntity;
import com.example.demo.projections.PersonProjection;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public ResponseEntity<PersonResponseDTO> savePerson(@RequestBody PersonRequestDTO personRequestDTO)
    {
        return new ResponseEntity<>(personService.savePerson(personRequestDTO), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<Page<PersonProjection>> findByFirstName(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size)
    {
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<>(personService.findAllPersons(pageable),HttpStatus.OK);
    }
}
