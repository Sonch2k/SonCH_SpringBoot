package com.Monstarlab.SonCH.exception;

import com.Monstarlab.SonCH.response.ResponseMessage;
import lombok.Getter;

@Getter
public class UnauthorizedException extends Exception {
    private String status;

    public UnauthorizedException(final ResponseMessage responseMessage, Object... params) {
        super(responseMessage.getMessage(params));
        this.status = responseMessage.getStatus();
    }
}
