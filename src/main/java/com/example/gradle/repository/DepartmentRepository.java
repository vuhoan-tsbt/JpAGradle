package com.example.gradle.repository;


import com.example.gradle.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    @Query("select d from Department d where d.name =:name")
    Optional<Department> getByNameDepartment(String name);

    @Query("select d from Department d where d.name= :name and d.id=:id and d.value=:value ")
    Optional<Department> getByDepartment(String name, Integer id, Float value);
}
