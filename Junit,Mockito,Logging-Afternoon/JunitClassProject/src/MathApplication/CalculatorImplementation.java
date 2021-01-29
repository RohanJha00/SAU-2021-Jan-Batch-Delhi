package MathApplication;

public class CalculatorImplementation implements CalculatorService{
    public int add(int inputA,int inputB) {
        return inputA + inputB;
    }

    public int sub(int inputA, int inputB) {
        return inputA - inputB;
    }

    public int mult(int inputA,int inputB) {
        return inputA * inputB;
    }

    public int div(int inputA, int inputB) {
        return inputA/inputB;
    }
}
