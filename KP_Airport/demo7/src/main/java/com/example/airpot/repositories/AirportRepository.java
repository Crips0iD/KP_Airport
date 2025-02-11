package com.example.airpot.repositories;

import java.util.List;

import com.example.airpot.models.airport1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<airport1, Long> {

    @Query("SELECT p FROM airport1 p WHERE concat(p.AirportID,'', p.city,'', p.name, '',p.country, '') LIKE %?1%")
    List<airport1> search(String keyword);

}
