package com.Monstarlab.SonCH.services.impl;

import com.Monstarlab.SonCH.repository.UserRepository;
import com.Monstarlab.SonCH.response.Response;
import com.Monstarlab.SonCH.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
public class UsserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public Response getListUser() {
        return Response.builder()
                .status("200")
                .message("get seccssfully")
                .Data(Collections.singletonList(userRepository.findAll()))
                .build();
    }
}
