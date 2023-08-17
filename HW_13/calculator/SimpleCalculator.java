package HW_13.calculator;

public class SimpleCalculator implements IMathOperations<Double>{
    public Double sum(Double a, Double b){
        return a + b;
    }
    public Double sub(Double a, Double b){
        return a - b;
    }
    public Double mult(Double a, Double b){
        return a * b;
    }
    public Double div(Double a, Double b){
        return a / b;
    }
}
