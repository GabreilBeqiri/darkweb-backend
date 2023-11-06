package com.example.gunz.armet;

import com.example.gunz.armet.Armet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ArmetRepository extends JpaRepository<Armet, Long> {



    @Query(value = "Select * from Armet u where u.gun_name = ?1 ",nativeQuery = true)
    public List<Armet>  findArmetByIdNumber(@Param("gun_name") String Gun_name) ;
    @Query(value = "Select * from Armet u where u.id = ?1 ",nativeQuery = true)
    public Armet  findArmetById(@Param("id") int id) ;

}
