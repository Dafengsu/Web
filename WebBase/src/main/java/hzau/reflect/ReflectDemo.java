package hzau.reflect;

import hzau.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @description:
 * @author: su
 * @date: 2020/2/13
 */
public class ReflectDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class<Person> personClass = Person.class;
        for (Constructor<?> constructor : personClass.getConstructors()) {
            System.out.println(constructor);
        }

        Constructor<Person> constructor = personClass.getConstructor();
        Person person = constructor.newInstance();
        System.out.println(person);
        System.out.println(Person.class.newInstance());
    }
}
