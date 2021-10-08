package com.Monstarlab.SonCH.controller;

import com.Monstarlab.SonCH.exception.BadRequestException;
import com.Monstarlab.SonCH.exception.DataDuplicatedException;
import com.Monstarlab.SonCH.request.AuthRequest;
import com.Monstarlab.SonCH.request.RegisterRequest;
import com.Monstarlab.SonCH.response.Response;
import com.Monstarlab.SonCH.response.ResponseMessage;
import com.Monstarlab.SonCH.services.AuthenticateService;
import com.Monstarlab.SonCH.services.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class RegisterController {
    private RegisterService registerService;

    @PostMapping("/register")
    public Response registerController(@Valid @RequestBody RegisterRequest request) throws BadRequestException {


        try {
            Response response = registerService.registerPerfom(request);
            return response;
        }catch (DataDuplicatedException e) {
            throw new BadRequestException(ResponseMessage.DuplicatedUsername);
        }
    }
}
