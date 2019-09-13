package com.mmelo.rabbit.web.advice;

import com.mmelo.rabbit.commons.ApplicationMessage;
import com.mmelo.rabbit.vo.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

import static java.time.Instant.now;
import static java.util.Arrays.asList;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.ResponseEntity.status;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleException (final Exception e) {
        return status(BAD_REQUEST)
                .body(this.constructErrorResponse(BAD_REQUEST, ApplicationMessage.BAD_REQUEST.getMessage()));
    }

    private ErrorResponse constructErrorResponse (final HttpStatus httpStatus, final String... messages) {
        return ErrorResponse.builder()
                .timestamp(now())
                .status(httpStatus.value())
                .error(httpStatus.getReasonPhrase())
                .messages(asList(messages))
                .build();
    }
}
