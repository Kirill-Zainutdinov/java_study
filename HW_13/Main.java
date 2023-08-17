package HW_13;

import HW_13.calculator.IMathOperations;
import HW_13.calculator.SimpleCalculator;
import HW_13.logger.ILogger;
import HW_13.logger.FileLogger;
import HW_13.view.CalculatorView;

public class Main {
    public static void main(String[] args) {

        ILogger logger = new FileLogger("db.txt");
        IMathOperations calculator = new SimpleCalculator();
        CalculatorView view = new CalculatorView(calculator, logger);

        view.run();
    }
}

// 1. интерфейс калькулятора с элементарными операциями
// 2. имплементация - с их реализациями
// 3. вьюшка для работы с любой фигнёй у которой есть интерфейс
// 4. фигня для логгировая - записи в файл
// 5. фигня которая умеет записывать куда угодно, в которую кидаем фигню для записи в файл
