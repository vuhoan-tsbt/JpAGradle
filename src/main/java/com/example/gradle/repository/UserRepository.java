package com.example.gradle.repository;

import com.example.gradle.entity.User;
import com.example.gradle.repository.sql.UserSql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository< User,Integer>, UserSql {
    @Query("select u from User u where u.email=:email and u.phone=:phone")
    Optional<User> getByEmailAndPhone(String email,String phone);

}
