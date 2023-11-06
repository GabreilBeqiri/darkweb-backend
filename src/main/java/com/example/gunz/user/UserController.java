package com.example.gunz.user;

import com.example.gunz.security.UserInfoDetails;
import com.example.gunz.user.dto.DeleteUserDto;
import com.example.gunz.user.dto.EditUserDto;
import com.example.gunz.user.dto.RegisterUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("api/v1/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
    @Autowired
    private UserService userService;


    @PostMapping("/add")
    public ResponseEntity<User> saveUser(@RequestBody RegisterUserDto registerUserDto) {
        return userService.saveUser(registerUserDto);
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody RegisterUserDto request) {
        return userService.saveUser(request);
    }

    @GetMapping("/single")
    public ResponseEntity<User> userDetail() {
        UserInfoDetails user = (UserInfoDetails) this.getAuthentication().getPrincipal();
        return userService.getUserDetail(user.getUsername());
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return userService.getAllUsers();
    }


    @PatchMapping("/edit")
    public ResponseEntity<User> editUser(@RequestBody EditUserDto editUserDto) {
        return userService.edit(editUserDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DeleteUserDto> deleteUser(@PathVariable int id)
    {
        return userService.deleteById(Long.parseLong(String.valueOf(id)));


    }


}
