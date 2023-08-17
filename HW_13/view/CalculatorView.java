package HW_13.view;

import java.util.Scanner;
import HW_13.calculator.IMathOperations;
import HW_13.logger.ILogger;

public class CalculatorView {
    
    private IMathOperations<Double> calculator;
    private ILogger logger;

    public CalculatorView(IMathOperations<Double> _calculator, ILogger _logger){
        calculator = _calculator;
        logger = _logger;
    }

    public void run() {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в наш калькулятор без регистрации и смс!");
        while (true) {
            System.out.println("Введите первое число:");
            double a = iScanner.nextDouble();
            System.out.println("Введите второе число:");
            double b = iScanner.nextDouble();
            System.out.println("1. Сложить");
            System.out.println("2. Вычесть");
            System.out.println("3. Умножить");
            System.out.println("4. Разделить");
            System.out.println("Выберите действие: ");
            int choice = iScanner.nextInt();
            if (choice == 1){
                double c = calculator.sum(a, b);
                String result = String.format("%f ADD %f = %f", a, b, c);
                System.out.println(result);
                logger.log(result);
            }
            else if (choice == 2){
                double c = calculator.sub(a, b);
                String result = String.format("%f SUB %f = %f", a, b, c);
                System.out.println(result);
                logger.log(result);
            }
            else if (choice == 3){
                double c = calculator.mult(a, b);
                String result = String.format("%f MULT %f = %f", a, b, c);
                System.out.println(result);
                logger.log(result);
            }
            else if (choice == 4){
                double c = calculator.div(a, b);
                String result = String.format("%f DIV %f = %f", a, b, c);
                System.out.println(result);
                logger.log(result);
            }
            System.out.println("Попробуем ещё раз?");
            System.out.println("1. Да");
            System.out.println("2. Нет");
            choice = iScanner.nextInt();
            if (choice == 2){
                break;
            }
        }
        iScanner.close();
    }
}
