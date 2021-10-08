package com.Monstarlab.SonCH.controller;

import com.Monstarlab.SonCH.exception.UnauthorizedException;
import com.Monstarlab.SonCH.request.AuthRequest;
import com.Monstarlab.SonCH.response.Response;
import com.Monstarlab.SonCH.response.ResponseMessage;
import com.Monstarlab.SonCH.services.AuthenticateService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class AuthenticateController {
    private AuthenticateService authenticateService;

    @PostMapping("/auth")
    public Response authController(@Valid @RequestBody AuthRequest authRequest) throws UnauthorizedException {
        try {
            Response response = authenticateService.performAuthenticate(authRequest);
            return response;
        } catch (AuthenticationException e) {
            throw new UnauthorizedException(ResponseMessage.AuthenticateUserFailed);
        }
    }
}
