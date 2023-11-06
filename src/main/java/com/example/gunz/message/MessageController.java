package com.example.gunz.message;

import com.example.gunz.armet.Armet;
import com.example.gunz.security.UserInfoDetails;
import com.example.gunz.user.User;
import com.example.gunz.user.dto.DeleteUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/message")
public class MessageController {
    @Autowired MessageService messageService;
    @Autowired
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
    @GetMapping
    public ResponseEntity<List<Message>> getMessage()
    { UserInfoDetails user = (UserInfoDetails) this.getAuthentication().getPrincipal();
        return messageService.getAllMessages(user.getUsername());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DeleteUserDto> deleteMsg(@PathVariable Long id)
    {
        return messageService.deleteById(id);


    }
}
