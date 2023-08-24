package com.travel.repo;

import com.travel.Entitties.Booking;
import com.travel.Entitties.Bus;
import com.travel.Entitties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BusRepo extends JpaRepository<Bus,Integer> {
    @Query(value = "select * from bus",nativeQuery = true)
    List<Bus> findallbus();

    @Query(value = "select * from bus where pnr_no=:id",nativeQuery = true)
    Bus findbypnrId(@Param("id") int  id);
    //findByCustomer_Customerid


}
