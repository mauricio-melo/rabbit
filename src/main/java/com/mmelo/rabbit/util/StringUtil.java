package com.mmelo.rabbit.util;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class StringUtil {

    public String toCamelCase(final String text) {
        final StringBuilder camelCaseString = new StringBuilder();
        Arrays.stream(text.split("([ ])+"))
                .forEach(part -> camelCaseString.append(toProperCase(part)));
        camelCaseString.setCharAt(0, Character.toLowerCase(camelCaseString.charAt(0)));
        return camelCaseString.toString();
    }

    private String toProperCase(final String text) {
        return text.substring(0, 1).toUpperCase() +
                text.substring(1).toLowerCase();
    }
}