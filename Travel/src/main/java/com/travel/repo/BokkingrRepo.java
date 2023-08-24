package com.travel.repo;

import com.travel.Entitties.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BokkingrRepo extends JpaRepository<Booking, Integer> {
    @Query(value = "select * from booking", nativeQuery = true)
    List<Booking> findAllBookings();

    @Query(value = "select * from booking where Booking_id=:id", nativeQuery = true)
    Booking findbooking(@Param("id") int id);

    @Query(value = "select * from booking where User_id=:uid", nativeQuery = true)
    List<Booking> getuserBookings(@Param("uid") int id);

    @Query(value = "select b.* from booking b JOIN bus a  on b.Booking_id=a.Booking_id where a.Booking_id=:id", nativeQuery = true)
    Booking findetils(@Param("id") int id);

    @Query(value = "select b.* from booking b JOIN flight a  on b.Booking_id=a.Booking_id where a.Booking_id=:id", nativeQuery = true)
    Booking findetilsflight(@Param("id") int id);

    @Query(value = "select b.* from booking b JOIN train a  on b.Booking_id=a.Booking_id where a.Booking_id=:id", nativeQuery = true)
    Booking findetilstrain(@Param("id") int id);

}
