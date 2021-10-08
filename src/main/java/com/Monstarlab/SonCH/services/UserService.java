package com.Monstarlab.SonCH.services;

import com.Monstarlab.SonCH.exception.DataDuplicatedException;
import com.Monstarlab.SonCH.response.ListUserResponse;
import com.Monstarlab.SonCH.response.Response;

public interface UserService {
    public ListUserResponse getListUser();
}
