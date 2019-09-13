package com.mmelo.rabbit.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplicationMessage {
    BAD_REQUEST("The request is invalid");

    private final String message;
}
