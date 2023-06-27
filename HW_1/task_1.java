package HW_1;
import java.util.Scanner;
public class task_1 {
    public static void main(String[] args){


        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите натуральное число: ");
        int n = iScanner.nextInt();

        int factorial = 1;
        for(int i = 2; i <= n; i++){
            factorial *= i;
        } 
        System.out.printf("Факториал числа: %d\n", factorial);

        // что вообще это значит? ))
        // Вычислить n-ое треугольного число (сумма чисел от 1 до n)?
        // как-то не по-русски и не по-математически звучит
        int summ = (n * (n + 1)) / 2;
        System.out.printf("Сумма чисел: %d\n", summ);
    }
}
