package com.company;

import forTest.ObjectForTest;
import forTest.ObjectForTest2;
import org.junit.jupiter.api.Test;
import somePackage.SomeBean;

import java.lang.reflect.Field;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InjectorTests {

    @Test
    void InterfaceTest() { //Данные тесты подстраиваются под Properties
        try {
            SomeBean testBean =  (new Injector()).inject(new SomeBean());
            Properties properties = new Properties();
            properties.load(getClass().getResourceAsStream("/injector.properties"));
            Field field1 = testBean.getClass().getDeclaredField("field1");
            field1.setAccessible(true);
            Field field2 = testBean.getClass().getDeclaredField("field2");
            field2.setAccessible(true);
            assertEquals(properties.getProperty("somePackage.SomeInterface"),  field1.get(testBean).getClass().getName(),
                    "somePackage.SomeInterface должен соответствовать " + properties.getProperty("somePackage.SomeInterface") +
                     ", а не " + field1.get(testBean).getClass().getName());
            assertEquals(properties.getProperty("somePackage.SomeOtherInterface"),  field2.get(testBean).getClass().getName(),
                    "somePackage.SomeOtherInterface должен соответствовать " + properties.getProperty("somePackage.SomeOtherInterface") +
                            ", а не " + field1.get(testBean).getClass().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void firstTest() {
        try {
            Properties properties = new Properties();
            properties.load(getClass().getResourceAsStream("/injector.properties"));
            assertEquals("field1: " + properties.getProperty("forTest.TestInterface") +
                    "; field2: " + properties.getProperty("forTest.TestObject"),
                    (new Injector()).inject(new ObjectForTest()).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void secondTest() {
        try {
            Properties properties = new Properties();
            properties.load(getClass().getResourceAsStream("/injector.properties"));
            assertEquals("field1: " + properties.getProperty("forTest.Test2Interface") +
                    "; field2: " + properties.getProperty("forTest.Test2Object"),
                    (new Injector()).inject(new ObjectForTest2()).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
