package com.sstinson.calcengine;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        performCalculations();
        Divider divider = new Divider();
        doCalculation(divider, 100.0, 50.0);
        performMoreCalculations();
        executeInteractively();
    }

    private static CalculateBase createCalculation(MathOperation operation, double leftVal, double rightVal){

        CalculateBase calculation = null;
        switch(operation){
            case ADD:
                calculation = new Adder(leftVal, rightVal);
                break;
            case SUBTRACT:
                calculation = new Subtracter(leftVal, rightVal);
                break;
            case MULTIPLY:
                calculation = new Multiplier(leftVal, rightVal);
                break;
            case DIVIDE:
                calculation = new Divider(leftVal, rightVal);
                break;
        }

        return calculation;

    }

    static void executeInteractively(){
        System.out.println("Enter an operation and two numbers:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperation(parts);

    }

    private static void performOperation(String[] parts){

        MathOperation operation = MathOperation.valueOf(parts[0].toUpperCase());
        double leftVal = Double.parseDouble(parts[1]);
        double rightVal = Double.parseDouble(parts[2]);
        CalculateBase calculation = createCalculation(operation, leftVal, rightVal);
        calculation.calculate();
        System.out.println("Operation performed: " + operation);
        System.out.println(calculation.getResult());
    }
    static void performMoreCalculations(){
        CalculateBase[] calculations = {
                new Divider(100.0, 50.0),
                new Adder(25.0, 92.0),
                new Subtracter(225.0,17.0),
                new Multiplier(11.0, 3.0),
        };
        System.out.println("Array calculations");
        for(CalculateBase calculation: calculations){
            calculation.calculate();
            System.out.println("result = " + calculation.getResult());
        }
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