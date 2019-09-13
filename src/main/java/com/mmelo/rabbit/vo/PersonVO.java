package com.mmelo.rabbit.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonVO {

    @NotNull
    private String fullName;

    @NotNull
    private String position;
}
