package com.Monstarlab.SonCH.services;

import com.Monstarlab.SonCH.exception.DataDuplicatedException;
import com.Monstarlab.SonCH.request.ChangeRequest;
import com.Monstarlab.SonCH.request.RegisterRequest;
import com.Monstarlab.SonCH.response.BaseResponse;
import javafx.scene.control.TextFormatter;

public interface RegisterService {
    public BaseResponse registerPerfom(RegisterRequest registerRequest) throws DataDuplicatedException;
    public BaseResponse changePerform(ChangeRequest registerRequest) throws DataDuplicatedException;

    public BaseResponse removePerform(RegisterRequest registerRequest) throws DataDuplicatedException;
}
