package com.cherrypicker.cherrypick3r.global.exception.customException;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }

}
