package com.au2021.service;

public class CalculatorService {

	public int calculate(String inputB, String inputA,String symbol)  throws Exception {
		int a = Integer.parseInt(inputA);
		int b = Integer.parseInt(inputB);
		int res = 0;

		switch (symbol) {
			case "+":
				res = a+b;
				break;
			case "-":
				res = a-b;
				break;
			case "*":
				res = a*b;
				break;
			case "/":
				if (b == 0) {
					throw new DivisionByZeroException();
				}
				res = a/b;
				break;
		}
		return res;
	}

}