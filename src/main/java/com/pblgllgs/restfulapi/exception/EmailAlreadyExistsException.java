package com.pblgllgs.restfulapi.exception;
/*
 *
 * @author pblgl
 * Created on 19-11-2024
 *
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailAlreadyExistsException extends RuntimeException {
    private String message;

    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
