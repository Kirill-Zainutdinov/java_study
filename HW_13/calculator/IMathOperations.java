package HW_13.calculator;

public interface IMathOperations<Type> {
    public Type sum(Type a, Type b);
    public Type sub(Type a, Type b);
    public Type mult(Type a, Type b);
    public Type div(Type a, Type b);
}
