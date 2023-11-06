package com.example.gunz.accessories;

import com.example.gunz.armet.Armet;
import com.example.gunz.armet.ArmetRepository;
import com.example.gunz.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccessoriesService {

    @Autowired
    private AccessoriesRepository accessoriesRepository;

    public ResponseEntity<List<Accessories>> getAllAccessories(){
        List<Accessories> accessoriess = this.accessoriesRepository.findAll().stream().toList();
        return new ResponseEntity<>(accessoriess, HttpStatus.OK);
    }

    public ResponseEntity<Accessories> getSingleAccessories(Long id){
        Accessories accessoriess = this.accessoriesRepository.findById(id).get();
        return new ResponseEntity<>(accessoriess, HttpStatus.OK);
    }
    public ResponseEntity<Accessories> saveAccessories(RegisterAccessoriesDto registerAccessoriesDto) {
        Optional<Accessories> AccessoriesByIdNumber = this.accessoriesRepository
                .findAccessoriesByIdNumber(registerAccessoriesDto.getAcc_name()).stream().findAny();


        if (AccessoriesByIdNumber.isEmpty()) {
            Accessories accessories = new Accessories();
            accessories.setAcc_name(registerAccessoriesDto.getAcc_name());
            accessories.setDescription(registerAccessoriesDto.getDescription());
            accessories.setPrice(registerAccessoriesDto.getPrice()  );


            accessories = this.accessoriesRepository.save(accessories);
            return new ResponseEntity<>(accessories, HttpStatus.OK);
        } else
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
    public void setImageToSingleAccess(String path,String id){
        Accessories access = this.accessoriesRepository.findById(Long.parseLong(id)).get();
        if(access != null){
            access.setPath(path);
            accessoriesRepository.save(access);
        }
    }

}


