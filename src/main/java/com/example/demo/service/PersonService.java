package com.example.demo.service;

import com.example.demo.dto.PersonRequestDTO;
import com.example.demo.dto.PersonResponseDTO;
import com.example.demo.person.PersonEntity;
import com.example.demo.projections.PersonProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonService {
    PersonResponseDTO savePerson(PersonRequestDTO personEntity);
    Page<PersonProjection> findAllPersons(Pageable pageable);
}
