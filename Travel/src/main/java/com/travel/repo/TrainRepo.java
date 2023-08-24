package com.travel.repo;

import com.travel.Entitties.Bus;
import com.travel.Entitties.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface TrainRepo extends JpaRepository<Train,Integer> {
    @Query(value = "select * from train",nativeQuery = true)
    List<Train> findalltrain();

    @Query(value = "select * from train where pnr_no=:id",nativeQuery = true)
    Train findbypnrId(@Param("id") int  id);
}
