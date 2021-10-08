package com.Monstarlab.SonCH.services;

import com.Monstarlab.SonCH.exception.DataDuplicatedException;
import com.Monstarlab.SonCH.request.RegisterRequest;
import com.Monstarlab.SonCH.response.Response;

public interface RegisterService {
    public Response registerPerfom(RegisterRequest registerRequest) throws DataDuplicatedException;
}
