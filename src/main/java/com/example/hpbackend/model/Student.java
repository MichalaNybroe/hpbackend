package com.example.hpbackend.model;

import com.example.hpbackend.House;
import com.example.hpbackend.Pet;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.TermVector;

import javax.persistence.*;

@Entity
@Indexed
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Field(termVector = TermVector.YES, name = "student_id")
    private int id;

    @Column(nullable = false)
    @Field(termVector = TermVector.YES)
    private String firstName;

    @Field(termVector = TermVector.YES)
    private String middleName;

    @Column(nullable = false)
    @Field(termVector = TermVector.YES)
    private String lastName;

    @Column(nullable = false)
    private int yearOfBirth;

    @Enumerated(EnumType.ORDINAL)
    //@Field(termVector = TermVector.YES)
    private House house;

    private int schoolYear;

    @Enumerated(EnumType.ORDINAL)
    private Pet pet;

    @Column(unique = true)
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int age) {
        this.yearOfBirth = age;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int year) {
        this.schoolYear = year;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
