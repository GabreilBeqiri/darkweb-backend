package com.example.gunz.message;

import com.example.gunz.accessories.Accessories;
import com.example.gunz.armet.Armet;
import com.example.gunz.files.MessageRepository;
import com.example.gunz.user.User;
import com.example.gunz.user.UserRepository;
import com.example.gunz.user.dto.DeleteUserDto;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository ;
    @Autowired
    private UserRepository  userRepository;

    public void postNewMessageForAccessories(Set<Accessories> accessories , String User){

       accessories.forEach(it -> {
           this.messageRepository.save(new Message(it.getAcc_name(), User));
        });
    }
    public void postNewMessageForGunzz(Set<Armet> armets, String User){

        armets.forEach(it -> {
            this.messageRepository.save(new Message(it.getGun_name(),User));
        });
    }
    public ResponseEntity<List <Message>> getAllMessages(String email) {

        List<Message> messages = this.messageRepository.findAll().stream().filter(it ->
                it.getEmail().equals(email )).toList();
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    public ResponseEntity<DeleteUserDto> deleteById(Long id)
    {
        messageRepository.deleteById(id);
        return new ResponseEntity<DeleteUserDto>(new DeleteUserDto("U fshi"), HttpStatus.OK);
    }
}
