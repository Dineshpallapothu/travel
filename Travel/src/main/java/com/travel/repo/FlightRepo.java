package com.travel.repo;

import com.travel.Entitties.Bus;
import com.travel.Entitties.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepo extends JpaRepository<Flight , Integer> {
    @Query(value = "select * from flight",nativeQuery = true)
    List<Flight> findallbus();

    @Query(value = "select * from flight where pnr_no=:id",nativeQuery = true)
     Flight findbypnrId(@Param("id") int id);
}
