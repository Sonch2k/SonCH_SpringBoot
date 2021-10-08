package com.Monstarlab.SonCH.exception;

import com.Monstarlab.SonCH.response.ResponseMessage;
import lombok.Getter;

    @Getter
    public class BadRequestException extends Exception {
        private String status;

        public BadRequestException(final ResponseMessage responeMessage, Object... params) {
            super(responeMessage.getMessage(params));
            this.status = responeMessage.getStatus();
        }
    }

