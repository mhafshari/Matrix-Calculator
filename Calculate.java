/**
 * calculated class created by @mhafshari
 * this class has 5 method include add,sub,mul these are main operation for matrix
 * next method is "staticMul" for doing factor to matrix for example implementing 2X, this method get one static number like 2
 * and one matrix then calculate 2X matrix , make all element of matrix double
 * and the last method "doOperand" for implementing expression this method get two matrix and one operand then print result
 */


package com.company;

import java.util.ArrayList;

public class Calculate {
    public void add(Matrix first, Matrix second) {
        //check size of two matrix for add ( number of row and column should be equal)
        if (first.getRowNumber() == second.getRowNumber() && first.getColNumber() == second.getColNumber()) {
            Matrix result = new Matrix();
            int rowNumber = first.getRowNumber();
            //split each row of matrix and extract each element of each matrix and
            //add them then store in new matrix (result matrix)
            for (int i = 0; i < rowNumber; i++) {
                ArrayList<Float> a = first.splitRow(i);
                ArrayList<Float> b = second.splitRow(i);
                String c = "";
                for (int j = 0; j < a.size(); j++) {
                    float res = a.get(j) + b.get(j);
                    if (j == 0)
                        c += String.valueOf(res);
                    else
                        c = c + "," + String.valueOf(res);
                }
                result.setMatrix(c);
            }
            result.printMatrix();
        } else
            System.out.println("the size of two matrix are not appropriate for add");
    }

    public void sub(Matrix first, Matrix second) {
        //check size of two matrix for sub ( number of row and column should be equal)
        if (first.getRowNumber() == second.getRowNumber() && first.getColNumber() == second.getColNumber()) {
            //split each row of matrix and extract each element of each matrix and
            //sub them then store in new matrix (result matrix)
            Matrix result = new Matrix();
            int rowNumber = first.getRowNumber();
            for (int i = 0; i < rowNumber; i++) {
                ArrayList<Float> a = first.splitRow(i);
                ArrayList<Float> b = second.splitRow(i);
                String c = "";
                for (int j = 0; j < a.size(); j++) {
                    float res = a.get(j) - b.get(j);
                    if (j == 0)
                        c += String.valueOf(res);
                    else
                        c = c + "," + String.valueOf(res);
                }
                result.setMatrix(c);
            }
            result.printMatrix();
        } else
            System.out.println("the size of two matrix are not appropriate for sub");
    }

    public void mul(Matrix first, Matrix second) {
        // check if column of first matrix is equal with row of second matrix
        if (first.getColNumber() == second.getRowNumber()) {
            Matrix result = new Matrix();
            //each row of first matrix should mul with all column of second matrix and store in result matrix
            for (int j = 0; j < first.getColumn(0).size(); j++) {
                String r = "";
                ArrayList<Float> a = first.splitRow(j);
                for (int i = 0; i < second.splitRow(0).size(); i++) {
                    ArrayList<Float> b = second.getColumn(i);
                    int c = 0;
                    for (int l = 0; l < b.size(); l++)
                        c += a.get(l) * b.get(l);
                    if (i == 0)
                        r += c;
                    else
                        r = r + "," + c;
                }
                result.setMatrix(r);
            }
            result.printMatrix();
        } else
            System.out.println("the size of two matrix are not appropriate for mul");
    }

    public Matrix staticMul(Float staticNumber, Matrix matrix) {
        Matrix result = new Matrix();
        //seprate all the element of matrix and mul them with factor
        for (int i = 0; i < matrix.getRowNumber(); i++) {
            String r = "";
            for (int j = 0; j < matrix.splitRow(i).size(); j++) {
                if (j == 0)
                    r += matrix.splitRow(i).get(j) * staticNumber;
                else
                    r = r + "," + matrix.splitRow(i).get(j) * staticNumber;
            }
            result.setMatrix(r);
        }
        return result;
    }

    public void doOperand(String operand, Matrix X, Matrix Y) {

        if (operand.equals("+"))
            add(X, Y);
        if (operand.equals("*"))
            mul(X, Y);
        if (operand.equals("-"))
            sub(X, Y);
    }
}
