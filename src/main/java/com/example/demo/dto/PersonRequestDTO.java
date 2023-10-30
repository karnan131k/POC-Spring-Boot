package com.example.demo.dto;

import jakarta.persistence.Column;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
public class PersonRequestDTO {

    private String firstName;

    private String lastName;

    private String address;
}
