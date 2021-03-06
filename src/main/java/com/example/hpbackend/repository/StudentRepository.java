package com.example.hpbackend.repository;

import com.example.hpbackend.House;
import com.example.hpbackend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findById(int id);

    @Query("SELECT s FROM Student s WHERE s.house = ?1")
    List<Student> findByHouse(House House);

    @Query(value = "SELECT * from student where match(first_name, middle_name, last_name) against (?1)", nativeQuery = true)
    List<Student> findByIdOrName(String searchInput);
}
