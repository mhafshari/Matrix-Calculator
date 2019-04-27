package com.company;

public class Expression {
    private String term1 = "";
    private String term2 = "";
    private String operand;
    private Integer indexOfOperand;
    private int c = 0;

    //this method get the expression and split it to an array then find the term (factor) of matrix for example if Expression
//is 2X+3Y this method return 2
    public String findFirstTerm(String expression) {
        String[] spil = expression.split("");
        if (spil[0].equals("X") || spil[0].equals("Y"))
            term1 = "1";
        else {
            while (c != spil.length - 1) {
                term1 += spil[c];
                if (spil[c + 1].equals("X")) {
                    break;
                }
                c++;
            }
        }
        return term1;
    }

    public String findOperand(String expression) {
        String[] spil = expression.split("");
        if (spil[0].equals("X") || spil[0].equals("Y"))
            operand = spil[1];
        else {
            while (c != spil.length - 1) {
                if (spil[c + 1].equals("X") || spil[c + 1].equals("Y")) {
                    operand = spil[c + 2];
                    break;
                }
                c++;
            }
        }
        return operand;
    }

    public Integer indexOfOperand(String expression) {
        String[] spil = expression.split("");
        if (spil[0].equals("X") || spil[0].equals("Y"))
            indexOfOperand = 1;
        else {
            while (c != spil.length - 1) {
                if (spil[c + 1].equals("X") || spil[c + 1].equals("Y")) {
                    indexOfOperand = c + 2;
                    break;
                }
                c++;
            }
        }
        return indexOfOperand;
    }

    //this method get the expression and split it to an array then find the term (factor) of second matrix for example if Expression
//is 2X+3Y this method return 3
    public String findSecondTerm(String expression, int indexOfOperand) {
        String[] spil = expression.split("");
        int counter = indexOfOperand + 1;
        if (spil[counter].equals("X") || spil[counter].equals("Y"))
            term2 = "1";
        else {
            while (counter != spil.length - 1) {
                term2 += spil[counter];
                if (spil[counter + 1].equals("Y")) {
                    break;
                }
                counter++;
            }
        }
        return term2;
    }

    //if factor of an expression has Parentheses this method remove it
    public Float removeParentheses(String term) {
        String[] spil = term.split("");
        if (spil[0].equals("(") && spil[spil.length - 1].equals(")")) {
            String newTerm = "";
            c = 1;
            while (c != spil.length - 1) {
                newTerm += spil[c];
                c++;
            }
            return Float.valueOf(newTerm);
        } else
            return Float.valueOf(term);

    }
}
