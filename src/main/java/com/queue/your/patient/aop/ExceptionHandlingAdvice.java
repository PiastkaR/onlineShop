package com.queue.your.patient.aop;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static org.springframework.core.annotation.AnnotatedElementUtils.findMergedAnnotation;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static java.util.Optional.ofNullable;

@ControllerAdvice
public class ExceptionHandlingAdvice {

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    ResponseEntity<ErrorMessage> handleDataIntegrityViolationException(Exception e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getLocalizedMessage());
        return new ResponseEntity<>(errorMessage, resolveAnnotatedResponseStatus(e));
    }

    HttpStatus resolveAnnotatedResponseStatus(Exception e) {
        return ofNullable(findMergedAnnotation(e.getClass(), ResponseStatus.class))
                .map(ResponseStatus::value)
                .orElse(INTERNAL_SERVER_ERROR);
    }

    @Getter
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(NON_NULL)
    class ErrorMessage {
        private String message;
        private String details;

        ErrorMessage(String msg) {
            this.message = msg;
        }
    }
}
