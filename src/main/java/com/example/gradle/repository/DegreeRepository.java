package com.example.gradle.repository;

import com.example.gradle.entity.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DegreeRepository extends JpaRepository<Degree, Integer> {
    @Query("select d from Degree d where d.name= :name")
    Optional<Degree> getByName(String name);

    @Query("select d from Degree d where  d.id=:id")
    Optional<Degree> getByIdDegree( Integer id);


}
