package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.UserInRole;
import com.example.demo.services.UserInRoleServices;

@RestController
@RequestMapping("/users/{userId}/roles/{roleId}")
public class UserInRoleController {
    //Asignación de un rol a un usuario
    //Roles disponibles
    //Usuarios con rol de admin etc
 
    @Autowired
    private UserInRoleServices userInRoleServices;
 
    @PostMapping
    public ResponseEntity<UserInRole> assingRole(@PathVariable("userId") Integer userId,
                                                 @PathVariable("roleId") Integer roleId) {
 
        return new ResponseEntity<UserInRole>(userInRoleServices.assingRole(userId, roleId), HttpStatus.CREATED);
    }
 
}