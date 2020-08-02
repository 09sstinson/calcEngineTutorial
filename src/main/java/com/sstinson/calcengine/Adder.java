package com.sstinson.calcengine;

public class Adder extends CalculateBase {

    @Override
    public void calculate() {
        double value = getLeftVal() + getRightVal();
        setResult(value);
    }

    public double test(){
        return 1.0;
    }
}
