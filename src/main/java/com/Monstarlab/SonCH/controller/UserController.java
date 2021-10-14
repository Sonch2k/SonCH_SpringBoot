package com.Monstarlab.SonCH.controller;

import com.Monstarlab.SonCH.exception.BadRequestException;
import com.Monstarlab.SonCH.response.BaseResponse;
import com.Monstarlab.SonCH.response.ListUserResponse;
import com.Monstarlab.SonCH.services.UserService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    private UserService userService;
    @ApiResponses(value = {
            @ApiResponse(code = 403, message = "Forbidden",response = BaseResponse.class),
            @ApiResponse(code = 404, message = "Not Found",response = BaseResponse.class),
            @ApiResponse(code = 401, message = "Unauthorized",response = BaseResponse.class)})
    @GetMapping("/list")
    public ListUserResponse getListController()  throws BadRequestException {
            return userService.getListUser();
    }
}
