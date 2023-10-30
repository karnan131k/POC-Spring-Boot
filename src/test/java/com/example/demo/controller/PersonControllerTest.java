package com.example.demo.controller;

import com.example.demo.dto.PersonRequestDTO;
import com.example.demo.dto.PersonResponseDTO;
import com.example.demo.mapping.JsonUtils;
import com.example.demo.service.PersonService;
import com.jayway.jsonpath.spi.json.JsonProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {

    @MockBean
    private PersonService personService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new PersonController(personService)).build();
    }

    @Test
    public void testSavePerson() throws Exception {
        // Create a sample request object
        PersonRequestDTO requestDTO = PersonRequestDTO.builder()
                .firstName("karnan")
                .lastName("sooriyakumar")
                .address("colombo").build();

        // Create a sample response object
        PersonResponseDTO responseDTO = PersonResponseDTO.builder()
                .firstName("karnan")
                .lastName("sooriyakumar").build();

        // Mock the behavior of the personService
        Mockito.when(personService.savePerson(requestDTO)).thenReturn(responseDTO);

        // Perform a POST request using MockMvc

        mockMvc.perform(MockMvcRequestBuilders.post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.toJson(requestDTO)))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.CREATED.value()))
                .andExpect(MockMvcResultMatchers.content().json(JsonUtils.toJson(responseDTO)));
    }
}