package com.Monstarlab.SonCH.services;

import com.Monstarlab.SonCH.exception.DataDuplicatedException;
import com.Monstarlab.SonCH.request.RegisterRequest;
import com.Monstarlab.SonCH.response.BaseResponse;

public interface RegisterService {
    public BaseResponse registerPerfom(RegisterRequest registerRequest) throws DataDuplicatedException;
}
