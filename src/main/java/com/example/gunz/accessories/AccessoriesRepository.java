package com.example.gunz.accessories;

import com.example.gunz.armet.Armet;
import com.example.gunz.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccessoriesRepository extends JpaRepository<Accessories, Long> {

    @Query(value = "Select * from accessories u where  u.acc_name = ?1",nativeQuery = true)
    public List<Accessories> findAccessoriesByIdNumber( @Param("acc_name") String Acc_name);
    @Query(value = "Select * from accessories u where  u.id = ?1",nativeQuery = true)
    public Accessories findAccessoriesById( @Param("id") int id);
}
