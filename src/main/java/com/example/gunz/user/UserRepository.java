package com.example.gunz.user;

import com.example.gunz.armet.Armet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {


    @Query(value = "Select * from users u where u.password = ?1 OR u.name = ?2",nativeQuery = true)
    public List<User> findUserByIdNumber(@Param("password") String password,@Param("name") String name);

    @Query(value = "Select * from users u where u.password = ?1",nativeQuery = true)
    public List<User> findUserByPassword(@Param("password") String password);


    @Query(value = "Select * from users u where u.email = ?1 ",nativeQuery = true)
    Optional<User> findUserByIdNumberAuth(@Param("email") String email);

    @Query(value = "Select * from users u where u.email = ?1 ",nativeQuery = true)
    User findUserByIdEmail(@Param("email") String email);

    @Query(value = "Select * from users u where u.id = ?1 ",nativeQuery = true)
    User findUserById(@Param("id") Integer id);



}
