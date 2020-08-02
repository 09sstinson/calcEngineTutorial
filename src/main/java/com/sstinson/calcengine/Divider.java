package com.sstinson.calcengine;

public class Divider extends CalculateBase{
    @Override
    public void calculate() {
        double value = getLeftVal() != 0 ? getLeftVal() / getRightVal(): 0.0;
        setResult(value);
    }
}
