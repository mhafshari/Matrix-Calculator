package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Matrix {
    private int rowNumber = 0;
    private Map<Integer, String> matrix = new HashMap<>();
//this method get a row string and add it to a matrix and be a row of matrix
    public void setMatrix(String row) {
        matrix.put(rowNumber, row);
        rowNumber++;
    }

    public void printMatrix() {
        System.out.println(matrix);
    }

    //check if entered matrix is correct or not (number of column for each row should be identical)
    //if are identical the flag being true otherwise false
    public boolean validateMatrix() {
        int size = getColNumber();
        boolean flag = false;
        if (getRowNumber() == 1)
            flag = true;
        else {
            for (int i = 1; i < matrix.size(); i++) {
                if (splitRow(i).size() != size) {
                    flag = false;
                    break;
                } else {
                    flag = true;
                }
            }
        }
        return flag;
    }
//this method get a number of row and split that row then save each element of row to an arrayList
    public ArrayList<Float> splitRow(int r) {
        String[] token = matrix.get(r).split(",");
        ArrayList<Float> row = new ArrayList<>();
        for (int i = 0; i < token.length; i++)
            row.add(i, Float.valueOf(token[i]));
        return row;
    }

    public int getRowNumber() {
        return matrix.size();
    }

    public int getColNumber() {
        return splitRow(0).size();
    }
    //this method get a number of column and split that column then save each element of column to an arrayList
    public ArrayList<Float> getColumn(int k) {
        ArrayList<Float> column = new ArrayList<>();
        for (int i = 0; i < getRowNumber(); i++) {
            ArrayList<Float> token = splitRow(i);
            column.add(i, Float.valueOf(token.get(k)));
        }
        return column;
    }
}
