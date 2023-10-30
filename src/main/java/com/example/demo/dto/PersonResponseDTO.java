package com.example.demo.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data
public class PersonResponseDTO {
    private String firstName;
    private String lastName;
}
