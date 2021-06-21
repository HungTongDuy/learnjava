package com.example.demo.LearnController;

import javax.validation.constraints.NotNull;

public class StudentRequest {

    private String name;

    @NotNull
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "StudentRequest { name = " + this.getName() + ", email = " + this.getEmail() + " }";
    }
}
