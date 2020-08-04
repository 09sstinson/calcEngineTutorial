package com.sstinson.calcengine;

public class PowerOf implements MathProcessing {
    private String formattedOutput;
    public String getKeyWord() {
        return "power";
    }


    public double doCalculation(double leftVal, double rightVal) {
        double product = Math.pow(leftVal, rightVal);
        formattedOutput = leftVal + " to the power of " + rightVal + " is " + product;
        return product;
    }


    public String getFormattedOutput(){
        return formattedOutput;
    }

}
