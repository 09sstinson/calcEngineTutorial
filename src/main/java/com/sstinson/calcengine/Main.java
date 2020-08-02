package com.sstinson.calcengine;

public class Main {

    public static void main(String[] args){
        performCalculations();
        Divider divider = new Divider();
        doCalculation(divider, 100.0, 50.0);
    }

    static void doCalculation(CalculateBase calculation, double leftVal, double rightVal) {
        calculation.setLeftVal(leftVal);
        calculation.setRightVal(rightVal);
        calculation.calculate();
        System.out.println("Result = " + calculation.getResult());

    }

    public static void performCalculations(){

        MathEquation[] equations = new MathEquation[4];

        equations[0] = new MathEquation(100.0, 50.0,'d');
        equations[1] = new MathEquation(25.0, 92.0,'a');
        equations[2] = new MathEquation(225.0, 17.0,'s');
        equations[3] = new MathEquation(11.0, 3.0,'m');

        for(MathEquation equation: equations){
            equation.execute();
            System.out.println("Result = " + equation.getResult());
        }

        System.out.println("Average result: " + MathEquation.getAverageResult());

        MathEquation equationOverload = new MathEquation('d');
        double leftVal = 9.0;
        double rightVal = 2.0;
        equationOverload.execute(leftVal, rightVal);
        System.out.println("Overloaded method result: " + equationOverload.getResult());

        int leftInt = 9;
        int rightInt = 2;
        equationOverload.execute(leftInt, rightInt);
        System.out.println("Overloaded result with ints: " + equationOverload.getResult());
    }

}