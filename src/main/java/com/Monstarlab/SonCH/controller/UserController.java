package com.Monstarlab.SonCH.controller;

import com.Monstarlab.SonCH.exception.BadRequestException;
import com.Monstarlab.SonCH.exception.DataDuplicatedException;
import com.Monstarlab.SonCH.response.ListUserResponse;
import com.Monstarlab.SonCH.response.Response;
import com.Monstarlab.SonCH.response.ResponseMessage;
import com.Monstarlab.SonCH.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    private UserService userService;
    @GetMapping("/list")
    public ListUserResponse getListController()  throws BadRequestException {
            return userService.getListUser();

    }
}
