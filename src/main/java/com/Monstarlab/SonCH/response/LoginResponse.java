package com.Monstarlab.SonCH.response;

import com.Monstarlab.SonCH.response.information.LoginInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public class LoginResponse extends BaseResponse<LoginInfo>{

    public LoginResponse(String status, LoginInfo Data, String message) {
        super(status, Data, message);
    }

    public LoginResponse(ResponseMessage responeMessage, Object... params) {
        super(responeMessage, params);
    }
}
