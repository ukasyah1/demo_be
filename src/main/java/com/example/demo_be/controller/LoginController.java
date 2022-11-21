package com.example.demo_be.controller;

import java.util.Base64;

import javax.validation.Valid;

import com.example.demo_be.base.response.Response;
import com.example.demo_be.response.LoginResponse;
import com.example.demo_be.service.userService.LoginService;
import com.example.demo_be.util.ResponseUtil;
import com.example.demo_be.vo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

   @Autowired
   LoginService service;

   @Autowired
   private ResponseUtil responseUtil;

   @PostMapping("/login")
   public Response<LoginResponse> login(@RequestBody @Valid User user) {

      String encodedPassword = Base64.getEncoder().encodeToString(user.getPassword().getBytes());

      LoginResponse loginResponse = service.login(user.getUsername(), encodedPassword);

      return responseUtil.generateResponseSuccess(loginResponse);
   }

   protected UserDetails getLoginUserInfo(Authentication authentication) {

      return (UserDetails) authentication.getPrincipal();
   }

   protected String getLoginUsername(Authentication authentication) {

      return this.getLoginUserInfo(authentication).getUsername();
   }

}
