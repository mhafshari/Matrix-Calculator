package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculate c = new Calculate();
        System.out.println("Define the first matrix: ");
        Matrix x = new Matrix();
        Scanner matrix = new Scanner(System.in);
        String row;
        // check if the user enter empty line , terminate input
        while (!(row = matrix.nextLine()).equals("")) {
            x.setMatrix(row);
        }
        //check if entered matrix is correct or not (number of column for each row should be identical)
        if (!x.validateMatrix()) {
            System.out.println("Entered matrix is incorrect!! \n Please try again");
        } else {

            System.out.println("Define the second matrix:");
            Matrix y = new Matrix();
            Scanner matrix2 = new Scanner(System.in);
            String row2;
            // check if the user enter empty line , terminate input
            while (!(row2 = matrix2.nextLine()).equals("")) {
                y.setMatrix(row2);
            }
            if (!y.validateMatrix())
                System.out.println("Entered matrix is incorrect!! \n Please try again");
            else {
                System.out.println("Enter your polynomial expression: ");
                Scanner exp = new Scanner(System.in);
                String polyn = exp.nextLine();
                Expression ex1 = new Expression();
                //remove all space of the polynomial expression
                String polyExp = polyn.replaceAll("\\s+", "");

                //extract factor of first matrix (X)
                String termX = ex1.findFirstTerm(polyExp);

                //extract operand of expression
                String operand = ex1.findOperand(polyExp);
                int index = ex1.indexOfOperand(polyExp);
                //extract factor of second matrix (Y)
                String termY = ex1.findSecondTerm(polyExp, index);

                //removing parentheses and convert factor to float(from string to float)
                Float a = ex1.removeParentheses(termX);
                Float b = ex1.removeParentheses(termY);
                //do factor to matrix
                Matrix firstMatrix = c.staticMul(a, x);
                Matrix secondMatrix = c.staticMul(b, y);
                //calculate the expression
                System.out.println("Result is: ");
                c.doOperand(operand, firstMatrix, secondMatrix);

            }
        }
    }

}

