package HW_4;

import java.util.LinkedList;
import java.util.Scanner;

public class task_3 {

    

    public static void main(String[] args) {
        calc();
    }

    public static void calc(){
        LinkedList<double[]> list = new LinkedList<double[]>();
        Scanner iScanner = new Scanner(System.in);
        while (true){
            System.out.println("Что будем делать?: ");
            System.out.println("1. Складывать");
            System.out.println("2. Вычитать");
            System.out.println("3. Умножать");
            System.out.println("4. Делить");
            System.out.println("5. Вывести историю операций");
            System.out.println("6. Удалить последнюю операцию");
            System.out.println("7. С меня хватит");
            int choice = iScanner.nextInt();
            if (choice < 1 || choice > 7) {
                System.out.println("Неправильный выбор");
                continue;
            }
            else if (choice == 5){
                printOperations(list);
                continue;
            }
            else if (choice == 6){
                list.removeLast();
                continue;
            }
            else if (choice == 7){
                break;
            }
            System.out.println("Введите первое число: ");
            double a = iScanner.nextDouble();
            System.out.println("Введите второе число: ");
            double b = iScanner.nextDouble();
            operation(list, choice, a, b);
        }
        iScanner.close();
    }

    public static void operation(LinkedList<double[]> list, int choice, double a, double b){
        double result = 0;
        if (choice == 1){
            result = a + b;
        }
        else if (choice == 2){
            result = a - b;
        }
        else if (choice == 3){
            result = a * b;
        }
        else if (choice == 4){
            result = a / b;
        }
        double[] op = new double[3];
        op[0] = a;
        op[1] = b;
        op[2] = result;
        list.add(op);
        System.out.printf("Ответ: %f\n", result);
    }

    public static void printOperations(LinkedList<double[]> list){
        for(int i = 0; i < list.size(); i++){
            double[] op = list.get(i);
            System.out.printf("оператор 1: %f оператор 2: %f ответ: %f\n", op[0], op[1], op[2]);
        } 
    }
}
