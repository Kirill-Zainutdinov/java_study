package HW_13.calculator;

public class SimpleCalculator implements IMathOperations{
    public double sum(double a, double b){
        return a + b;
    }
    public double sub(double a, double b){
        return a - b;
    }
    public double mult(double a, double b){
        return a * b;
    }
    public double div(double a, double b){
        return a / b;
    }
}
