package com.example.gunz.armet;


import com.example.gunz.armet.dto.RegisterGunsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArmetService {

    @Autowired
    private ArmetRepository armetRepository;

    public ResponseEntity<List<Armet>> getAllArmet(String type) {
        if(type.equals("hunting")){
            List<Armet> armet = this.armetRepository.findAll().stream().filter(it -> it.getPurpose().equals("Hunting")).toList();
            return new ResponseEntity<>(armet, HttpStatus.OK);
        } else if(type.equals("protection")){
            List<Armet> armet = this.armetRepository.findAll().stream().filter(it -> it.getPurpose().equals("Protection")).toList();
            return new ResponseEntity<>(armet, HttpStatus.OK);
        }

        return null;




    }


    public ResponseEntity<Armet> saveArmet (RegisterGunsDto registerGunsDto){
        Optional<Armet> ArmetByIdNumber = this.armetRepository
                .findArmetByIdNumber(registerGunsDto.getGun_name())
                .stream().findAny();

        if (ArmetByIdNumber.isEmpty()) {
            Armet armet = new Armet();
            armet.setGun_name(registerGunsDto.getGun_name());
            armet.setRange_of_fire(registerGunsDto.getRange_of_fire());
            armet.setGuns_length(registerGunsDto.getGuns_length());
            armet.setIn_service(registerGunsDto.getIn_service());
            armet.setFire_rate(registerGunsDto.getFire_rate());
            armet.setPrice(registerGunsDto.getPrice()  );
            armet.setPurpose(registerGunsDto.getPurpose());

            armet = this.armetRepository.save(armet);
            return new ResponseEntity<>(armet, HttpStatus.OK);
        } else
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    public void setImageToSingleArme(String path,String id){
        Armet arme = this.armetRepository.findById(Long.parseLong(id)).get();
        if(arme != null){
            arme.setPath(path);
            armetRepository.save(arme);
        }
    }
}
