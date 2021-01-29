package MathApplication;

public class Calculator {
    private CalculatorService calService;

    public int add(int inputA, int inputB){
        return calService.add(inputA, inputB);
    }

    public int sub(int inputA, int inputB){
        return calService.sub(inputA, inputB);
    }

    public int mult(int inputA, int inputB){
        return calService.mult(inputA, inputB);
    }

    public int div(int inputA, int inputB){
        return calService.div(inputA, inputB);
    }
}
