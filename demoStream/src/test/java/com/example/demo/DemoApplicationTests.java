package com.example.demo;

import javafx.util.Pair;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    @Test
    void testStream() {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7,8);

        IntStream.of(7,8,9,10).forEach(System.out::println);

        long count = numbers.stream().filter(element -> element % 2 == 0).limit(2).count();
        System.out.printf("There are %d elements that are even", count);
    }

    @Test
    void testForEach() {
        List<String> data = Arrays.asList("Java", "php", "Nodejs");
        data.stream().map(String::toUpperCase).forEach(System.out::println);
    }

    @Test
    void testCollect() {
        Stream<String> stream = Stream.of("Java", "C#", "C++", "PHP", "Javascript", "Java");
        Set<String> languages = stream.collect(Collectors.toSet());
        System.out.println(languages);
    }

    void withoutStream(List<Integer> numbers) {
        long count = 0;
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                count++;
            }
        }
        System.out.printf("There are %d elements that are even", count);
    }

    void withStream(List<Integer> numbers) {
        long count = numbers.stream().filter(element -> element % 2 == 0).count();
        System.out.printf("There are %d elements that are even", count);
    }

    @Test
    void testCompareSet() {
        Set<Student> studentSet1 = new HashSet<>();
        studentSet1.add(new Student("A", "10/10/10"));
        studentSet1.add(new Student("B", "11/11/10"));
        studentSet1.add(new Student("C", "11/12/10"));

        Set<Student> studentSet2 = new HashSet<>();
        studentSet2.add(new Student("D", "9/9/10"));
        studentSet2.add(new Student("E", "8/8/10"));
        studentSet2.add(new Student("F", "7/7/10"));

        System.out.println(studentSet1.equals(studentSet2));
    }

    @Test
    void equalsHashCode() {
        Student student1 = new Student("123", "student 1", "abc");
        Student student2 = new Student("123", "student 1", "abc");
        Student student3 = new Student("456", "student 2", "def");

        Set<Student> students = new HashSet<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        Stream<Student> studentStream = Stream.of(student1, student2, student3);

        Set<Student> studentSet = studentStream.collect(Collectors.toSet());

        for(Student student : studentSet) {
            System.out.println(String.format("Student: %s", student.toString()));
        }
    }

    @Test
    void parallelStream() {
        System.out.println("parallelStream");

        long startTime;
        long count;
        long endTime;
        long millis;

        startTime = System.nanoTime();

        count = createDummyData().stream().sorted().count();
        System.out.println(String.format("Count stream: %d", count));

        endTime = System.nanoTime();

        millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println(String.format("Sequential Time: %d", millis));

        startTime = System.nanoTime();

        count = createDummyData().parallelStream().sorted().count();
        System.out.println(String.format("Count parallelStream: %d", count));

        endTime = System.nanoTime();

        millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println(String.format("Parallel Time: %d", millis));
    }

    private List<String> createDummyData() {
        Integer total = 1000000;

        List<String> dummyData = new ArrayList<>();
        for(int i = 0; i < total; i++) {
            UUID uuid = UUID.randomUUID();
            dummyData.add(uuid.toString());
        }

        return dummyData;
    }

}
