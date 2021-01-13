package com.company;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {

    public <T> T inject(T obj){
        Class<?> aClass = obj.getClass(); // Преобразуем обйект в класс
        Properties properties = new Properties(); // Подключчаем injector.properties
        try {
            properties.load(getClass().getResourceAsStream("/injector.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Field field : aClass.getDeclaredFields()) { // Проходимся по всем полям
            field.setAccessible(true); // изменяем, для возможности работать с приватными полями
            try {
                if (field.getAnnotation(AutoInjectable.class) != null && field.get(obj) == null) { // если поле не иниц. и имеет аннотацию
                    field.set(obj, Class.forName(properties.getProperty(field.getType().getName())).getDeclaredConstructor().newInstance());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return obj;
    }
}
