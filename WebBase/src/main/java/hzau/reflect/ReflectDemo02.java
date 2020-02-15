package hzau.reflect;

import hzau.domain.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: su
 * @date: 2020/2/13
 */
public class ReflectDemo02 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Method eat = personClass.getMethod("eat",String.class);
        Person person = new Person();
        eat.invoke(person, "milk");


        for (Method method : personClass.getDeclaredMethods()) {
                System.out.println(method);
        }
    }
}
