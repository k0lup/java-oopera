package staff;

import java.util.Objects;

public class Person {
    private String name;
    private String surName;
    private final Gender gender;

    public Person(String name, String surName, Gender gender){
        if (name.isEmpty()) {
            System.out.println("Имя не может быть пустым. Будет использовано значение по умолчанию!");
            this.name = "Иван";
        } else {
            this.name = name;
        }
        if (surName.isEmpty()) {
            System.out.println("Фамилия не может быть пустой. Будет использовано значения по умолчанию!");
            this.name = "Иванов";
        } else {
            this.surName = surName;
        }
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(surName, person.surName) && gender == person.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName, gender);
    }

    @Override
    public String toString() {
        return "staff.Person{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", gender=" + gender +
                '}';
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getFullName(){
        return name + " " + surName;
    }
}
