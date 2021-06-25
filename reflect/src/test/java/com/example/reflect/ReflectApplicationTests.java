package com.example.reflect;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

@SpringBootTest
class ReflectApplicationTests {

    @Test
    void contextLoads() {
        try {
            getClassInfo();
        } catch (ClassNotFoundException | NoClassDefFoundError | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException ex) {
            ex.printStackTrace();
        }
    }

    private void getClassInfo() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> tClass = Dog.class;
        System.out.println(String.format("Name %s ", tClass.getName()));
        System.out.println(String.format("SimpleName %s", tClass.getSimpleName()));

        // Package
        Package tPackage = tClass.getPackage();
        System.out.println(String.format("Package %s", tPackage.getName()));

        // Modifier
        int modifiers = tClass.getModifiers();
        boolean isPublic = Modifier.isPublic(modifiers);
        boolean isPrivate = Modifier.isPrivate(modifiers);
        boolean isInterface = Modifier.isInterface(modifiers);
        boolean isAbstract = Modifier.isAbstract(modifiers);

        System.out.println(String.format("isPublic %s", isPublic));
        System.out.println(String.format("isPrivate %s", isPrivate));
        System.out.println(String.format("isInterface %s", isInterface));
        System.out.println(String.format("isAbstract %s", isAbstract));


        Class<?> tParent = tClass.getSuperclass();
        System.out.println(String.format("Parent Class %s", tParent.getName()));

        System.out.println("Interface classes");
        Class<?>[] itfClasses = tClass.getInterfaces();
        for(Class<?>itfClass : itfClasses) {
            System.out.println("- " + itfClass.getName());
        }

        System.out.println("Constructor Params");
        Constructor constructor = tClass.getConstructor(String.class, int.class);
        Class[] parameters = constructor.getParameterTypes();
        for(Class param : parameters) {
            System.out.println("- " + param.getName());
        }

        Dog dog1 = (Dog) constructor.newInstance("Dog1", 2);

        Dog dog2 = (Dog) constructor.newInstance("Dog2", 3);

    }

}
