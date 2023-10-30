package com.example.demo.controller;

import com.example.demo.dto.PersonRequestDTO;
import com.example.demo.dto.PersonResponseDTO;
import com.example.demo.service.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonControllerTestBackup {

    @InjectMocks
    private PersonController personController;

    @Mock
    private PersonService personService;

    @Test
    public void testSavePerson() {
        // Arrange
        PersonRequestDTO requestDTO = PersonRequestDTO.builder()
                .firstName("karnan")
                .lastName("sooriyakumar")
                .address("colombo").build();
        PersonResponseDTO responseDTO = PersonResponseDTO.builder()
                .firstName("karnan")
                .lastName("sooriyakumar").build();

        // Mock the behavior of the personService
        when(personService.savePerson(requestDTO)).thenReturn(responseDTO);

        // Act
        ResponseEntity<PersonResponseDTO> responseEntity = personController.savePerson(requestDTO);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(responseDTO, responseEntity.getBody());
    }
}