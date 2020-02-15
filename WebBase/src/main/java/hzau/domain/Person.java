package hzau.domain;

/**
 * @description:
 * @author: su
 * @date: 2020/2/13
 */
public class Person {
    private String name;
    private int age;

    public int salary;
    public String address;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                '}';
    }

    public void eat() {
        System.out.println("eat");
    }

    public void eat(String food) {
        System.out.println("eat " + food);
    }
}
