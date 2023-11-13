package com.example.gunz.price;

import com.example.gunz.selected.Selected;
import com.example.gunz.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query(value = "Select * from price u where u.id = ?1 ",nativeQuery = true)
    public Price findPriceById(@Param("id") Integer id);

    @Query(value = "Select sum(u.sales) from price u ",nativeQuery = true)
    public Integer findsumm() ;

    @Query(value = "SELECT sum(u.sales) FROM gunz.price u\n" +
            " where CAST(u.created_at AS DATE) = CAST( curdate() AS DATE); ",nativeQuery = true)
    public Integer findstodaysumm() ;

}
