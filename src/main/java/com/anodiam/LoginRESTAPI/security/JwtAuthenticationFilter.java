package com.anodiam.LoginRESTAPI.security;

import com.anodiam.LoginRESTAPI.model.LoginViewModel;
import com.anodiam.LoginRESTAPI.serviceRepository.User.GeneralEncoderDecoder;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private JwtProperties jwtProperties;
    private AuthenticationManager authenticationManager;
    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtProperties jwtProperties) {
        this.authenticationManager = authenticationManager;
        this.jwtProperties = jwtProperties;
    }

//    Trigger when we issue POST request to /login with username & password in the body of the request
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        // Grab credentials to map them to LoginViewModel
        LoginViewModel credentials = null;
        String username ="";
        try
        {
            credentials = new ObjectMapper().readValue(request.getInputStream(), LoginViewModel.class);
            username = new GeneralEncoderDecoder().encrypt(credentials.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create Login Token
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                username, credentials.getPassword(), new ArrayList<>());
        // Authenticate User
        Authentication auth = authenticationManager.authenticate(authenticationToken);
        return  auth;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult)
                                            throws IOException, ServletException {
        // Grab Principal
        UserPrincipal principal = (UserPrincipal) authResult.getPrincipal();
        // Create JWT Token
        String token = JWT.create()
                .withSubject(principal.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + jwtProperties.getEXPIRATION_TIME()))
                .sign(Algorithm.HMAC512(jwtProperties.getSECRET().getBytes()));

        // Add Token in response
        JSONArray array = new JSONArray();
        JSONObject item = new JSONObject();
        try
        {
            item.put("UserId", principal.getUser().getUserId());
            item.put("Token", token);
            array.put(item);
        }catch(Exception ex){}

        response.getOutputStream().print(new ObjectMapper().writeValueAsString(array.toString()));
        response.flushBuffer();
    }
}
