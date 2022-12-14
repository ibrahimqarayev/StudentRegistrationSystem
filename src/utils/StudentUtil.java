/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import beans.Config;
import beans.Student;

/**
 *
 * @author ibrahimqarayev
 */
public class StudentUtil {

    public static Student fillStudent() {
        String name = InputUtil.requiredText("Enter name: ");
        String surname = InputUtil.requiredText("Enter surname: ");
        int age = InputUtil.requiredNumber("Enter age: ");
        String className = InputUtil.requiredText("Enter class name: ");

        Student student = new Student(name, surname, age, className);
        return student;
    }

    public static void printAllRegisteredStudents() {
        if (Config.students == null) {
            return;
        }
        for (int i = 0; i < Config.students.length; i++) {
            Student student = Config.students[i];
            System.out.println(
                    "Name: " + student.getName()
                    + "\nSurname: " + student.getSurname()
                    + "\nAge: " + student.getAge()
                    + "\nClass name: " + student.getClassName()
                    + "\n------------------- ");
        }
    }

    public static void registerStudents() {
        System.out.println("How many students you will registration ?");

        int count = InputUtil.requiredNumber("Enter count");

        Config.students = new Student[count];

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ".Register");
            Student student = StudentUtil.fillStudent();
            Config.students[i] = student;

        }

        System.out.println("\nRegistration completed successfully !\n");
        StudentUtil.printAllRegisteredStudents();
    }

}
