package com.example.demo;

import java.util.Objects;

public class Student {

    private String id;

    private String name;

    private String day_of_birth;

    public Student(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay_of_birth() {
        return day_of_birth;
    }

    public void setDay_of_birth(String day_of_birth) {
        this.day_of_birth = day_of_birth;
    }

    public Student(String name, String day_of_birth) {
        this.name = name;
        this.day_of_birth = day_of_birth;
    }

    public Student(String id, String name, String day_of_birth) {
        this.id = id;
        this.name = name;
        this.day_of_birth = day_of_birth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{ " + "id = " + id + ", name = " + name + ", day_of_birth = " + day_of_birth + " }";
    }
}
