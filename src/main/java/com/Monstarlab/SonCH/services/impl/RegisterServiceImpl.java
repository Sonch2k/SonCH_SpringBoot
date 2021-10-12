package com.Monstarlab.SonCH.services.impl;

import com.Monstarlab.SonCH.entity.User;
import com.Monstarlab.SonCH.exception.DataDuplicatedException;
import com.Monstarlab.SonCH.repository.UserRepository;
import com.Monstarlab.SonCH.request.RegisterRequest;
import com.Monstarlab.SonCH.response.BaseResponse;
import com.Monstarlab.SonCH.services.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class RegisterServiceImpl implements RegisterService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public BaseResponse registerPerfom(RegisterRequest registerRequest) throws DataDuplicatedException {
        User user = new User();
        User result = userRepository.findByUsername(registerRequest.getUsername());
        if (Objects.nonNull(result)) {
            if (result.getUsername().equalsIgnoreCase(registerRequest.getUsername())) {
                throw new DataDuplicatedException("User with this email already exists: " + registerRequest.getUsername());
            }
        }
        BeanUtils.copyProperties(registerRequest, user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return BaseResponse.builder()
                .message("Register Success")
                .status("200")
                .Data(null)
                .build();
    }
}
