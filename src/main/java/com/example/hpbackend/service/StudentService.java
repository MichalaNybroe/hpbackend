package com.example.hpbackend.service;

import com.example.hpbackend.House;
import com.example.hpbackend.model.Student;
import com.example.hpbackend.repository.StudentRepository;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    EntityManager entityManager;

    public List<Student> showAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> showAllFromHouse(String house) {
        House checkHouse = House.valueOf(house.toUpperCase());
        return studentRepository.findByHouse(checkHouse);
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> showSearchedStudents(String searchInput) {
        //https://www.baeldung.com/hibernate-search

        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Student.class).get();

        Query query = queryBuilder.keyword().fuzzy().onFields("firstName", "middleName", "lastName", "id").matching(searchInput).createQuery();

        FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query, Student.class);

        List<Student> students = jpaQuery.getResultList();
        return students;
    }
}
