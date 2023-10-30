package com.example.demo.service;

import com.example.demo.dto.PersonRequestDTO;
import com.example.demo.dto.PersonResponseDTO;
import com.example.demo.mapping.Mapping;
import com.example.demo.person.PersonEntity;
import com.example.demo.projections.PersonProjection;
import com.example.demo.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;

    private final Mapping mapping;

    public PersonServiceImpl(PersonRepository personRepository, Mapping mapping) {
        this.personRepository = personRepository;
        this.mapping = mapping;
    }

    @Override
    public PersonResponseDTO savePerson(PersonRequestDTO personRequestDTO) {
        PersonEntity personEntity = PersonEntity.builder()
                .firstName(personRequestDTO.getFirstName())
                .lastName(personRequestDTO.getLastName())
                .address(personRequestDTO.getAddress())
                .build();
        PersonEntity person = personRepository.save(personEntity);
        return mapping.PersonEntitytoPersonResponseDTO(person);
    }

    @Override
    public Page<PersonProjection> findAllPersons(Pageable pageable) {
        return personRepository.findAllPersons(pageable);
    }


}
