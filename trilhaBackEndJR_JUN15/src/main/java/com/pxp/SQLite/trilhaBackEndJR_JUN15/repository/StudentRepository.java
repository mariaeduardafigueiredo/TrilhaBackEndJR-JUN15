package com.pxp.SQLite.trilhaBackEndJR_JUN15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pxp.SQLite.trilhaBackEndJR_JUN15.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    public boolean existsByEmail(String email);

    public List<Student> findByEmail(String email);

    @Query("select max(s.id) from Student s")
    public Integer findMaxId();
}
