package com.example.reflect;

@Excel(name = "Cat")
public class Dog extends Animal implements Say {

    public static final String SAY = "Gau Gau";
    public static final int NUMBER_OF_LEGS = 4;

    @ExcelColumn(index = 0, title = "name")
    private String name;

    @ExcelColumn(index = 1, title = "age")
    private int age;

    public Dog() { }

    public Dog(String name) {
        this.name = name;
        this.age = 1;
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String say() {
        return SAY;
    }

    @Override
    public int getNumberOfLegs() {
        return NUMBER_OF_LEGS;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
