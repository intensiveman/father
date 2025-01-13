package com.example.hotel;

import com.example.hotel.model.Student;

public class Test {

    public static void main(String[] args) {
        Student yixian = new Student(15, "yixian");
        modify(yixian);
        System.out.println(yixian.getAge());

    }

    public static void modify(Student student) {
        student.setAge(14);
    }
}
