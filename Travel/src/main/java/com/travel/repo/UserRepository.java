package com.travel.repo;


import com.travel.Entitties.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "select * from users",nativeQuery = true)
    List<User> findAllusers();
    @Query(value = "select * from users where User_id=:id",nativeQuery = true)
    User findbyUserId(@Param("id") int id);

    @Transactional
    @Query(value = "delete users where User_id=:id",nativeQuery = true)
     User  deleteyUserId(@Param("id")int id);
}