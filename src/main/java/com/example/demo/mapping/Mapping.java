package com.example.demo.mapping;

import com.example.demo.dto.PersonResponseDTO;
import com.example.demo.person.PersonEntity;
import lombok.*;
import org.springframework.stereotype.Component;


@Component
public class Mapping {
    public PersonResponseDTO PersonEntitytoPersonResponseDTO(PersonEntity personEntity){
        return PersonResponseDTO.builder()
                .firstName(personEntity.getFirstName())
                .lastName(personEntity.getLastName())
                .build();
    }
}
