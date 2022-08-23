package com.example.kurly_hack_festa.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "No data")
public class NoDateException extends RuntimeException {

    public NoDateException(String msg) {
        super(msg);
    }
}
