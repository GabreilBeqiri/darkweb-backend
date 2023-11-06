package com.example.gunz.selected;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SelectedRepository extends JpaRepository<Selected, Long> {
    @Query(value = "Select * from selected u where  u.name = ?1",nativeQuery = true)
    public List<Selected> findSelectedByName(@Param("name") String name);



}
