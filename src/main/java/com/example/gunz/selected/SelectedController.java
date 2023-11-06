package com.example.gunz.selected;


import ch.qos.logback.core.net.SMTPAppenderBase;
import com.example.gunz.accessories.Accessories;
import com.example.gunz.armet.Armet;
import com.example.gunz.security.UserInfoDetails;
import com.example.gunz.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/api/v1/selected")
public class SelectedController {
    @Autowired
    private SelectedService selectedService;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/static";
    @Autowired
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
    @PostMapping("/add")
    public ResponseEntity<User> saveselected(@RequestBody RegisterSelectedDto registerSelectedDto ){
        return selectedService.saveSelected(registerSelectedDto);
    }

    @PostMapping("/add/accesories")
    public ResponseEntity<User> saveselectedAccessories(@RequestBody RegisterSelectedAccDto registerSelectedAccDto ){
        return selectedService.saveSelectedAcc(registerSelectedAccDto);
    }
    @GetMapping("/accessories")
    public ResponseEntity<Set<Accessories>> getAllSelectedAccessories() {
        UserInfoDetails user = (UserInfoDetails) this.getAuthentication().getPrincipal();
        return selectedService.getAllSelectedAccessories(user.getUsername());
    }
    @GetMapping("/gunz")
    public ResponseEntity<Set<Armet>> getAllSelectedGuns() {
        UserInfoDetails user = (UserInfoDetails) this.getAuthentication().getPrincipal();
        return selectedService.getAllSelectedGuns(user.getUsername());
    }
    @DeleteMapping ("/delete/guns/{id}")
    public ResponseEntity<DeleteSelectetGunDto> deleteGunById (@PathVariable("id") int id){
        UserInfoDetails user =(UserInfoDetails) this.getAuthentication().getPrincipal();
        return selectedService.deleteGunById(id,user.getUsername());
    }
    @DeleteMapping ("/delete/accessories/{id}")
    public ResponseEntity<DeleteSelectedAccessDto> deleteAccessById (@PathVariable("id") int id){
        UserInfoDetails user =(UserInfoDetails) this.getAuthentication().getPrincipal();
        return selectedService.deleteAccById(id,user.getUsername());
    }
    @DeleteMapping("/delete/allGunzz")
    public ResponseEntity<DeleteSelectetGunDto> deleteAllSelectedGunz() {
        UserInfoDetails user = (UserInfoDetails) this.getAuthentication().getPrincipal();
        return selectedService.deleteAllSelectedGunzz(user.getUsername());
    }
    @DeleteMapping("/delete/allAcc")
    public ResponseEntity<DeleteSelectedAccessDto> deleteAllSelectedAceess() {
        UserInfoDetails user = (UserInfoDetails) this.getAuthentication().getPrincipal();
        return selectedService.deleteAllSelectedAceess(user.getUsername());
    }
}
