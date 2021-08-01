package com.prac.springsecurity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RoleService {

    public List<String> addDefaultRoleType() {
        List<String> roles = new ArrayList<String>();
        roles.add("ROLE_MEMBER");
        return roles;
    }

}
