package com.example.shopappbe.controllers;

import com.example.shopappbe.entities.User;
import com.example.shopappbe.response.MessageResponse;
import com.example.shopappbe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<User> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        return ResponseEntity.ok(currentUser);
    }

//    @GetMapping("/all")
//    public ResponseEntity<List<User>> allUsers() {
//        List <User> users = userService.allUsers();
//
//        return ResponseEntity.ok(users);
//    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    public ResponseEntity<MessageResponse> getAll(){
        List<User> ListUser = userService.allUsers();
        return ResponseEntity.ok(MessageResponse.builder()
                .message("lay thong tin thanh cong")
                .status(HttpStatus.OK.value())
                .data(ListUser)
                .build()
        );

    }
}