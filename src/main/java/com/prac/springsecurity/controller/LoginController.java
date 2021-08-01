package com.prac.springsecurity.controller;

import com.prac.springsecurity.domain.AuthenticationRequest;
import com.prac.springsecurity.service.JwtService;
import com.prac.springsecurity.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class LoginController {

    private final JwtService jwtService;
    private final RoleService roleService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthenticationRequest authenticationRequest) {

        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();
        List<String> roles = roleService.addDefaultRoleType();
        String token = jwtService.issue(username, password, roles);

        return new ResponseEntity<String>(token, HttpStatus.OK);
    }



}
