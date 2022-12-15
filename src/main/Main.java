/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import utils.InputUtil;
import utils.StudentUtil;

/**
 *
 * @author ibrahimqarayev
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int menu = InputUtil.requiredNumber("What do you want to do?"
                + "\n1.Register"
                + "\n2.Show all students"
                + "\n3.Find student"
                + "\n4.Update student\n");

        if (menu == 1) {
            StudentUtil.registerStudents();
        } else if (menu == 2) {
            StudentUtil.printAllRegisteredStudents();
        } else if (menu == 3) {

        }

    }

}