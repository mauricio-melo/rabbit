package com.mmelo.rabbit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDTO {
    private Long id;
    private String fullName;
    private String position;
    private String login;
}
