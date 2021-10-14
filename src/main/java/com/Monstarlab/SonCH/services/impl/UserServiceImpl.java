package com.Monstarlab.SonCH.services.impl;

import com.Monstarlab.SonCH.repository.UserRepository;
import com.Monstarlab.SonCH.response.ListUserResponse;
import com.Monstarlab.SonCH.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public ListUserResponse getListUser() {
        return ListUserResponse.builder()
                .status("200")
                .message("get seccssfully")
                .data(Collections.singletonList(userRepository.findAll()))
                .build();
    }
}
