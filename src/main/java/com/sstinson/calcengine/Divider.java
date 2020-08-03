package com.sstinson.calcengine;

public class Divider extends CalculateBase{

    public Divider(){};
    public Divider(double leftVal, double rightVal){
        super(leftVal, rightVal);
    }

    @Override
    public void calculate() {
        double value = getLeftVal() != 0 ? getLeftVal() / getRightVal(): 0.0;
        setResult(value);
    }
}
