package com.queue.your.patient.order;

public class AlreadyAcceptedException extends RuntimeException {

    public AlreadyAcceptedException(String msg) {
        super(msg);
    }
}
