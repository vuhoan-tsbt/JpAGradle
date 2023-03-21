package com.example.gradle.repository;

import com.example.gradle.entity.UserDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDegreeRepository extends JpaRepository<UserDegree, Integer> {
    @Query("select ud from UserDegree  ud where ud.id=:id")
    Optional<UserDegree> getByIdUserDegree(Integer id);
}
