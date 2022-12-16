/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import beans.Config;
import beans.Student;
import utils.InputUtil;
import utils.StudentUtil;

/**
 * @author ibrahimqarayev
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int menu = 0;
        while (true) {
            menu = InputUtil.requiredNumber("\nWhat do you want to do?"
                    + "\n1.Register"
                    + "\n2.Show all students"
                    + "\n3.Find student"
                    + "\n4.Update student\n");

            if (menu == 1) {
                StudentUtil.registerStudents();
            } else if (menu == 2) {
                StudentUtil.printAllRegisteredStudents();
            } else if (menu == 3) {
                StudentUtil.findStudentsAndPrint();
            } else if (menu == 4) {
                StudentUtil.updateStudent();
            }

        }


    }

}