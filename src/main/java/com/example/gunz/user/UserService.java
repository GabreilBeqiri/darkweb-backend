package com.example.gunz.user;

import com.example.gunz.security.UserInfoDetails;
import com.example.gunz.user.dto.DeleteUserDto;
import com.example.gunz.user.dto.EditUserDto;
import com.example.gunz.user.dto.RegisterUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class UserService {

    @Autowired
    private UserRepository  userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    public String test(){
        return "daja el emin";
    }

    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = this.userRepository.findAll().stream().toList();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    public ResponseEntity<User> saveUser(RegisterUserDto registerUserDto){
        Optional<User> userByIdNumber = userRepository
                .findUserByIdNumber(registerUserDto.getPassword(),registerUserDto.getName())
                .stream().findAny();

        if(userByIdNumber.isEmpty()) {
            User user = new User();
            user.setName(registerUserDto.getName());
            user.setSurname(registerUserDto.getSurname());
            user.setIdNumber(registerUserDto.getIdNumber());
            user.setEmail(registerUserDto.getEmail());
            user.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));
            user.setRole("USER");
            user = userRepository.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<User> edit(EditUserDto editUserDto){
//        passwordEncoder.encode(editUserDto.getNewPassword())

        try{




            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(editUserDto.getEmail(), editUserDto.getOldPassword()));
            UserInfoDetails passwordObject = (UserInfoDetails) authentication.getPrincipal();

            Optional<User> userByIdNumber = userRepository
                    .findUserByPassword(passwordObject.getPassword())
                    .stream().findAny();

            if(!userByIdNumber.isEmpty()) {

                User user = userByIdNumber.get();
                user.setName(editUserDto.getName());
                user.setSurname(editUserDto.getSurname());
                user.setEmail(editUserDto.getEmail());
                user.setPassword(passwordEncoder.encode(editUserDto.getNewPassword()));

                user = userRepository.save(user);
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
        } catch (Exception e){


        }
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<User> getUserDetail(String email){
        User users = this.userRepository.findUserByIdEmail(email);
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    public ResponseEntity<User> getUserID(String email){
        User users = this.userRepository.findUserByIdEmail(email);
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
//    public ResponseEntity<User> delete (Integer id){
//        User users = this.userRepository.findUserById(id);
//        return new ResponseEntity<>(users,HttpStatus.OK);
//    }

    //method that delete a user resource
    public ResponseEntity<DeleteUserDto> deleteById(Long id)
    {
        User user = userRepository.findUserById(Integer.parseInt(id.toString()));
        if(user != null){
            userRepository.delete(user);
            return new ResponseEntity<>(new DeleteUserDto("U Fshi"),HttpStatus.OK);
        } else{
            return new ResponseEntity<>(new DeleteUserDto("nuk u fshi"),HttpStatus.BAD_REQUEST);

        }
    }

    public  String getRolePerUserEmail(String email){
        try {
            User user = this.userRepository.findUserByIdEmail(email);
            if(user != null){
                return user.getRole();
            }
            return null;
        } catch (Exception e){
            return null;
        }
    }

}
