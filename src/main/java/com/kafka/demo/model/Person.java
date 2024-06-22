package com.kafka.demo.model;

import java.util.Objects;

public class Person {
    private Integer id;
    private String FirstName;

    private String LastName;

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(FirstName, person.FirstName) && Objects.equals(LastName, person.LastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, FirstName, LastName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }
}
