/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import beans.*;

/**
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
            System.out.println((i + 1) + "." + student.getFullInfo());
        }
    }

    public static void registerStudents() {

        int count = InputUtil.requiredNumber("How many students you will registration ?");

        Config.students = new Student[count];

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ".Register");
            Student student = StudentUtil.fillStudent();
            Config.students[i] = student;
        }
        System.out.println("\nRegistration completed successfully !\n");
        StudentUtil.printAllRegisteredStudents();
    }

    public static void findStudentsAndPrint() {
        String text = InputUtil.requiredText("Enter name,surname or class name: ");
        Student[] foundedStudents = findStudents(text);
        for (int i = 0; i < foundedStudents.length; i++) {
            System.out.println(foundedStudents[i].getFullInfo());
        }
    }

    public static Student[] findStudents(String text) {
        int count = 0;
        for (int i = 0; i < Config.students.length; i++) {
            Student student = Config.students[i];
            if (student.getName().contains(text) || student.getSurname().contains(text) || student.getClassName().contains(text)) {
                count++;
            }
        }

        Student[] result = new Student[count];
        int found = 0;
        for (int i = 0; i < Config.students.length; i++) {
            Student student = Config.students[i];
            if (student.getName().contains(text) || student.getSurname().contains(text) || student.getClassName().contains(text)) {
                student = result[found];
                found++;
            }
        }
        return result;

    }

    public static void updateStudentWIthNewObject() {
        StudentUtil.printAllRegisteredStudents();
        int i = InputUtil.requiredNumber("Enter the id of the student to be updated: ");
        System.out.println("Enter new information: ");
        Student student = StudentUtil.fillStudent();
        Config.students[i - 1] = student;
    }

    public static void updateStudentWithSameObject() {
        StudentUtil.printAllRegisteredStudents();
        int i = InputUtil.requiredNumber("Enter the id of the student to be updated: ");
        System.out.println("Enter new information: ");
        Student selectedStudent = Config.students[i - 1];
        String changeParams = InputUtil.requiredText(
                "what do you want to change? Example format : 'name','surname','className'");

        if (changeParams.contains("'name")) {
            selectedStudent.setName(InputUtil.requiredText("Name:"));
        }
        if (changeParams.contains("'surname")) {
            selectedStudent.setSurname(InputUtil.requiredText("Surname:"));
        }
        if (changeParams.contains("'className")) {
            selectedStudent.setSurname(InputUtil.requiredText("Class name:"));
        }
        if (changeParams.contains("'age")) {
            selectedStudent.setAge(InputUtil.requiredNumber("Age:"));
        }
    }

    public static void updateStudentWithSplit() {
        StudentUtil.printAllRegisteredStudents();
        int index = InputUtil.requiredNumber("Enter the id of the student to be updated: ");
        System.out.println("Enter new information: ");
        Student selectedStudent = Config.students[index - 1];
        String changeParams = InputUtil.requiredText(
                "what do you want to change? Example format : name,surname,className");
        String[] parameters = changeParams.split(",");
        for (int i = 0; i < parameters.length; i++) {
            String param = parameters[i];
            if (param.equalsIgnoreCase("name")) {
                selectedStudent.setName(InputUtil.requiredText("Name:"));
            } else if (param.equalsIgnoreCase("surname")) {
                selectedStudent.setName(InputUtil.requiredText("Surname:"));
            }else if(param.equalsIgnoreCase("age")){
                selectedStudent.setAge(InputUtil.requiredNumber("Age:"));
            }else if(param.equalsIgnoreCase("className")){
                selectedStudent.setClassName("Class name:");
            }
        }
    }
}