package com.example.gunz.selected;

import ch.qos.logback.classic.util.LogbackMDCAdapter;
import com.example.gunz.accessories.Accessories;
import com.example.gunz.accessories.AccessoriesRepository;
import com.example.gunz.accessories.RegisterAccessoriesDto;
import com.example.gunz.armet.Armet;
import com.example.gunz.armet.ArmetRepository;
import com.example.gunz.message.MessageService;
import com.example.gunz.user.User;
import com.example.gunz.user.UserRepository;
import com.example.gunz.user.dto.DeleteUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SelectedService {
    @Autowired
    private SelectedRepository selectedRepository;
@Autowired
private MessageService messageService ;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArmetRepository armetRepository;
    @Autowired
    private AccessoriesRepository accessoriesRepository;

    public ResponseEntity<Set<Accessories>> getAllSelectedAccessories(String email){
        Set<Accessories> selectedAccessories = new HashSet<>();
        User user = userRepository.findUserByIdEmail(email);
        if(user != null){
            selectedAccessories = user.getSelectedAccess();

        }
        return new ResponseEntity<>(selectedAccessories, HttpStatus.OK);
    }

    public ResponseEntity<Set<Armet>> getAllSelectedGuns(String email){
        Set<Armet> selectedGuns = new HashSet<>();
        User user = userRepository.findUserByIdEmail(email);
        if(user != null){
            selectedGuns= user.getSelectedGuns();

        }
        return new ResponseEntity<>(selectedGuns, HttpStatus.OK);
    }

    public ResponseEntity<User> saveSelected(RegisterSelectedDto registerSelectedDto) {

        try {
            User user = userRepository.findUserByIdEmail(registerSelectedDto.getUserEmail());
            Armet arma = armetRepository.findArmetById(registerSelectedDto.getGunId());

            if (user != null && arma != null) {
                Set<Armet> listOfGunsPerUser = user.getSelectedGuns();
                listOfGunsPerUser.add(arma);
                user.setSelectedGuns(listOfGunsPerUser);
                userRepository.save(user);
                return new ResponseEntity<>(user, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

            }

        } catch (Exception e) {
            System.out.println("error in saving selected " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }
    public ResponseEntity<User> saveSelectedAcc(RegisterSelectedAccDto registerSelectedAccDto) {

        try {
            User user = userRepository.findUserByIdEmail(registerSelectedAccDto.getUserEmail());
            Accessories acc = accessoriesRepository.findAccessoriesById(registerSelectedAccDto.getAccId());

            if (user != null && acc != null) {
                Set<Accessories> listOfAccessPerUser = user.getSelectedAccess();
                listOfAccessPerUser.add(acc);
                user.setSelectedAccess(listOfAccessPerUser );
                userRepository.save(user);
                return new ResponseEntity<>(user, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

            }

        } catch (Exception e) {
            System.out.println("error in saving selected " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }

    public ResponseEntity<DeleteSelectetGunDto> deleteGunById(int id, String email)
    {
        User user = userRepository.findUserByIdEmail(email);

        if (user != null){
            Set<Armet> selectedArmetPerUser = user.getSelectedGuns();

            selectedArmetPerUser = selectedArmetPerUser.stream().filter(it -> it.getId() != id).collect(Collectors.toSet());
            user.setSelectedGuns(selectedArmetPerUser);
            userRepository.save(user);
            return new ResponseEntity<>(new DeleteSelectetGunDto("U Fshi arma"),HttpStatus.OK);
        } else{
            return new ResponseEntity<>(new DeleteSelectetGunDto("nuk u fshi arma"),HttpStatus.BAD_REQUEST);

        }
    }
    public ResponseEntity<DeleteSelectedAccessDto> deleteAccById(int id, String email)
    {
        User user = userRepository.findUserByIdEmail(email);

        if (user != null){
            Set<Accessories> selectedAccPerUser = user.getSelectedAccess();

            selectedAccPerUser = selectedAccPerUser.stream().filter(it -> it.getId() != id).collect(Collectors.toSet());
            user.setSelectedAccess(selectedAccPerUser);
            userRepository.save(user);
            return new ResponseEntity<>(new DeleteSelectedAccessDto("U Fshi arma"),HttpStatus.OK);
        } else{
            return new ResponseEntity<>(new DeleteSelectedAccessDto("nuk u fshi arma"),HttpStatus.BAD_REQUEST);

        }


    }
    public ResponseEntity<DeleteSelectedAccessDto>deleteAllSelectedAceess ( String email)
    {
        User user = userRepository.findUserByIdEmail(email);

        if (user != null){

            Set<Accessories> accessoriesBeforeDelete = user.getSelectedAccess();
          this.messageService.postNewMessageForAccessories(accessoriesBeforeDelete, user.getEmail());

            user.setSelectedAccess(null);
            userRepository.save(user);
            return new ResponseEntity<>(new DeleteSelectedAccessDto("U Fshi arma"),HttpStatus.OK);
        } else{
            return new ResponseEntity<>(new DeleteSelectedAccessDto("nuk u fshi arma"),HttpStatus.BAD_REQUEST);

        }


    }
    public ResponseEntity<DeleteSelectetGunDto>deleteAllSelectedGunzz ( String email)
    {
        User user = userRepository.findUserByIdEmail(email);

        if (user != null){
            Set<Armet> accessoriesBeforeDelete = user.getSelectedGuns();
            this.messageService.postNewMessageForGunzz(accessoriesBeforeDelete,user.getEmail());

            user.setSelectedGuns(null);
            userRepository.save(user);
            return new ResponseEntity<>(new DeleteSelectetGunDto("U Fshi arma"),HttpStatus.OK);
        } else{
            return new ResponseEntity<>(new DeleteSelectetGunDto("nuk u fshi arma"),HttpStatus.BAD_REQUEST);

        }


    }

}
