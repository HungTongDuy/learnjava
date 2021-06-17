package com.example.demo.Static;

public class CounterWithoutStatic {

    private int count = 0;

    public CounterWithoutStatic() { }

    public void visit() {
        count++;
        System.out.println("count = " + count);
    }

}
