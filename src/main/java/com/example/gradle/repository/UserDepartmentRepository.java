package com.example.gradle.repository;

import com.example.gradle.entity.UserDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDepartmentRepository extends JpaRepository<UserDepartment, Integer> {
    @Query("select ud from UserDepartment  ud where ud.id=:id")
    Optional<UserDepartment> getByIdUserDepartment(Integer id);
}
