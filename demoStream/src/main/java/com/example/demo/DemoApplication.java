package com.example.demo;

import com.example.demo.GenericType.Bar;
import com.example.demo.GenericType.MyGeneric;
import com.example.demo.GenericType.PhoneName;
import com.example.demo.GenericType.StringAndValueEntry;
import com.example.demo.Static.CounterWithStatic;
import com.example.demo.Static.CounterWithoutStatic;
import com.example.demo.Static.MyWebsite;
import com.example.demo.Static.UsingStaticMethod;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        SpringApplication.run(DemoApplication.class, args);

        PhoneName phone = new PhoneName(123456, "One");

        System.out.println("Key " + phone.getKey());
        System.out.println("Value " + phone.getValue());

        StringAndValueEntry<Integer> stringAndValue = new StringAndValueEntry("One", 1234);

        System.out.println("Key " + stringAndValue.getKey());
        System.out.println("Value " + stringAndValue.getValue());

        MyGeneric<Bar> myGeneric = new MyGeneric<>(Bar.class);

        Bar bar = myGeneric.getTobject();

        bar.currentDate();

        // Demo static variable
        CounterWithoutStatic counterWithoutStatic1 = new CounterWithoutStatic();
        counterWithoutStatic1.visit();
        CounterWithoutStatic counterWithoutStatic2 = new CounterWithoutStatic();
        counterWithoutStatic2.visit();


        CounterWithStatic counterWithStatic1 = new CounterWithStatic();
        counterWithStatic1.visit();
        CounterWithStatic counterWithStatic2 = new CounterWithStatic();
        counterWithStatic2.visit();

        // Demo static method
        UsingStaticMethod demo1 = new UsingStaticMethod("Core Java");
        demo1.changePrint("admin.net");

    }

}
