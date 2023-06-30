package HW_1;

import java.util.Scanner;

public class task_3 {
    public static void main(String[] args){
        Scanner iScanner = new Scanner(System.in);

        while (true){
            System.out.println("Что будем делать?: ");
            System.out.println("1. Складывать");
            System.out.println("2. Вычитать");
            System.out.println("3. Умножать");
            System.out.println("4. Делить");
            System.out.println("5. С меня хватит");
            int choice = iScanner.nextInt();
            if (choice < 1 || choice > 5) {
                System.out.println("Неправильный выбор");
                continue;
            }
            else if (choice == 5){
                break;
            }
            System.out.println("Введите первое число: ");
            double a = iScanner.nextDouble();
            System.out.println("Введите второе число: ");
            double b = iScanner.nextDouble();
            if (choice == 1){
                System.out.printf("Ответ: %f\n", a + b);
            }
            else if (choice == 2){
                System.out.printf("Ответ: %f\n", a - b);
            }
            else if (choice == 3){
                System.out.printf("Ответ: %f\n", a * b);
            }
            else if (choice == 4){
                System.out.printf("Ответ: %f\n", a / b);
            }
        }

        iScanner.close();
    }
}
