package com.Monstarlab.SonCH.exception.handle;


import com.Monstarlab.SonCH.exception.BadRequestException;
import com.Monstarlab.SonCH.exception.UnauthorizedException;
import com.Monstarlab.SonCH.response.Response;
import com.Monstarlab.SonCH.response.ResponseMessage;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice
public class ApiExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ApiExceptionHandler.class);

    /**
     * All the unhandled exception is handled here
     *
     * @return Response
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response exceptionHandler(Exception e) {
        LOG.warn(e.getMessage());
        return new Response(ResponseMessage.DefaultInternalServerMessageError);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    public Response badRequestExceptionHandler(BadRequestException e) throws Exception {
        LOG.warn(e.getMessage());
        return new Response(e.getStatus(), Collections.singletonList("null"), e.getMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public Response unauthorizedExceptionHandler(UnauthorizedException e) {
        LOG.warn(e.getMessage());
        return new Response(e.getStatus(), Collections.singletonList("null"), e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Response methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) throws Exception {

        StringBuilder errorItemBuilder = new StringBuilder();

        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            String value = fieldError.getRejectedValue() == null ? "null" : fieldError.getRejectedValue().toString();

            errorItemBuilder.append(fieldError.getField()).append(", ");
        }

        String errorCode = ResponseMessage.InvalidAccessError.getStatus();
        String errorMessage = ResponseMessage.InvalidAccessError.getMessage(errorItemBuilder.toString());

        return new Response(errorCode, Collections.singletonList("null"), errorMessage);
    }
}