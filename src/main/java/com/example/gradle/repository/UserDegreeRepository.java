package com.example.gradle.repository;

import com.example.gradle.entity.UserDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDegreeRepository extends JpaRepository<UserDegree,Integer> {
}
