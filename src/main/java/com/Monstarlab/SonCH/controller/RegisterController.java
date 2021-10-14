package com.Monstarlab.SonCH.controller;

import com.Monstarlab.SonCH.exception.BadRequestException;
import com.Monstarlab.SonCH.exception.DataDuplicatedException;
import com.Monstarlab.SonCH.request.RegisterRequest;
import com.Monstarlab.SonCH.response.BaseResponse;
import com.Monstarlab.SonCH.response.ResponseMessage;
import com.Monstarlab.SonCH.services.RegisterService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiResponses(value = {
            @ApiResponse(code = 403, message = "Forbidden",response = BaseResponse.class),
            @ApiResponse(code = 404, message = "Not Found",response = BaseResponse.class),
            @ApiResponse(code = 201, message = "created",response = BaseResponse.class)})
    public BaseResponse registerController(@Valid @RequestBody RegisterRequest request) throws BadRequestException {
        try {
            BaseResponse response = registerService.registerPerfom(request);
            return response;
        }catch (DataDuplicatedException e) {
            throw new BadRequestException(ResponseMessage.DuplicatedUsername, request.getUsername());
        }
    }
}
