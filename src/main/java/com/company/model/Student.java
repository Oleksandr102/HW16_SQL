package com.company.model;

public class Student {

    private String first_name;
    private String last_name;
    private String City;
    private int age;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int id;

    public Student(int id, String first_name, String last_name, String city, int age) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        City = city;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", City='" + City + '\'' +
                ", age=" + age +
                '}';
    }

}
