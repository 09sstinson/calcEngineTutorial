package com.sstinson.calcengine;

public class MathEquation {
    private double leftVal;
    private double rightVal;
    private char opCode;
    private double result;
    private boolean testBlock;

    private static int numberOfCalcs;
    private static double sumOfResults;

    // Initialisation Block
    {
        testBlock = true;
        // Redundant example
    }

    // Static Initialisation Block
    static {
        numberOfCalcs = 0;
        sumOfResults = 0;
        // Redundant example
    }

    public MathEquation(char opCode){
        this.opCode = opCode;
    }

    public MathEquation(double leftVal, double rightVal, char opCode){
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    void execute() {
        switch(opCode){
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            case 'd':
                result = rightVal != 0 ? leftVal / rightVal : 0.0;
                break;
            default:
                System.out.println("Invalid opCode: "+ opCode);
                result = 0.0;
                break;
        }

        numberOfCalcs++;
        sumOfResults += result;
    }

    public void execute(double leftVal, double rightVal){
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        execute();
    }

    public void execute(int leftVal, int rightVal){
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        execute();
        result = (int) result;
    }

    public void setLeftVal(double leftVal){
        this.leftVal = leftVal;
    }

    public void setRightVal(double rightVal){
        this.rightVal = rightVal;
    }

    public static double getAverageResult(){
        return sumOfResults / numberOfCalcs;
    }

    public double getResult(){
        return result;
    }

}
