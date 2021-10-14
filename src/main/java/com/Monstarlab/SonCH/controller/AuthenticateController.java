package com.Monstarlab.SonCH.controller;

import com.Monstarlab.SonCH.exception.UnauthorizedException;
import com.Monstarlab.SonCH.request.AuthRequest;
import com.Monstarlab.SonCH.response.BaseResponse;
import com.Monstarlab.SonCH.response.LoginResponse;
import com.Monstarlab.SonCH.response.ResponseMessage;
import com.Monstarlab.SonCH.response.example.ModelErrorExample403;
import com.Monstarlab.SonCH.response.example.ModelErrorExample404;
import com.Monstarlab.SonCH.services.AuthenticateService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class AuthenticateController {
    private AuthenticateService authenticateService;
    @ApiResponses(value = {
            @ApiResponse(code = 403, message = "Forbidden",response = ModelErrorExample403.class),
            @ApiResponse(code = 404, message = "Not Found",response = ModelErrorExample404.class)})
    @PostMapping("/auth")
    public LoginResponse authController(@Valid @RequestBody AuthRequest authRequest) throws UnauthorizedException {
        try {
            LoginResponse response = authenticateService.performAuthenticate(authRequest);
            return response;
        } catch (AuthenticationException e) {
            throw new UnauthorizedException(ResponseMessage.AuthenticateUserFailed);
        }
    }
}
