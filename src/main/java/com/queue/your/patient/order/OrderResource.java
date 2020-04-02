package com.queue.your.patient.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;

@RestController
@RequiredArgsConstructor
public class OrderResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(Order.class);

    private final OrderService orderService;

    @PatchMapping(path = "/orders/{id}/accept")
    public void approve(@PathVariable @NotEmpty String id) {
        orderService.accept(id);
    }

    @ExceptionHandler(AlreadyAcceptedException.class)
    public ResponseEntity<ErrorMessage> alreadyAcceptedExceptionHandler(AlreadyAcceptedException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getLocalizedMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @Getter
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    class ErrorMessage {
        private String message;
    }

}
