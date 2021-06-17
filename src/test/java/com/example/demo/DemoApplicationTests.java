package com.example.demo;

import javafx.util.Pair;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;
import java.util.MissingResourceException;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    private Locale parseLocale(String locale) {
        String[] parts = locale.split("-");
        switch (parts.length) {
            case 3: return new Locale(parts[0], parts[1], parts[2]);
            case 2: return new Locale(parts[0], parts[1]);
            case 1: return new Locale(parts[0]);
            default: throw new IllegalArgumentException("Invalid locale: " + locale);
        }
    }

    @Test
    public void localeTest() {
        String locale = "vi-VN";
        Locale lo;

        try {
            lo = parseLocale(locale);
            System.out.printf("Locale " + lo);
            if (lo.getISO3Language() != null && lo.getISO3Country() != null) {
                System.out.printf("getISO3Country " + lo.getISO3Country());
            } else {
                System.out.printf("Invalid");
            }
        } catch (IllegalArgumentException | MissingResourceException ex) {
            System.out.printf(ex.getMessage());
        }
    }

    @Test
    public void testPair() {
        Pair<Integer, String> pair = new Pair<>(1, "One");
        System.out.println("Key: " + pair.getKey());
        System.out.println("Value: " + pair.getValue());
    }

}
