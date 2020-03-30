package com.queue.your.patient.cart;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class CartResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(CartResource.class);

    private final CartService cartService;

    @ResponseStatus(OK)
    @PostMapping("/cart/{item}")
    public void add(@PathVariable long item) {
        cartService.add(item);
    }

    @PostMapping("/cart/order")
    public ResponseEntity<IdReference> order() {
        final Cart cart = cartService.create();
        LOGGER.info("[{}]", cart);
        return ResponseEntity.ok(new IdReference(cart.getId()));
    }

    // warto dodawac na poczatku private final MandatoryKeyRequestValidator validato = new MKV(
    // required("sss"),
    //required("name"));

//    @ExceptionHandler
//    ResponseEntity handeValidation(final ValidationException exception) {
//        LOGGER.error("Request validaiton failed" , exception);
//        return new ResponseEntity(exception.getMessage(), HttpStatus.CONFLICT);
//    }

    @Value
    static class IdReference {
        final String id;
    }
}
