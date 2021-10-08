package com.Monstarlab.SonCH.sercurity;

import com.nimbusds.jose.shaded.json.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@Component
public class EntryPoint implements AuthenticationEntryPoint, Serializable {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        JSONObject jso = new JSONObject();
        jso.put("Status", "109");
        jso.put("data", "null");
        jso.put("massage", "fail to filter token");
//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Sai cmnr");
        response.getWriter().write(jso.toJSONString());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json;charset=UTF-8");
    }
}
