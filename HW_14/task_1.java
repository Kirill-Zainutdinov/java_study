package HW_14;

import java.util.Scanner;

public class task_1 {
    
    public static void main(String[] args){
        Scanner iScanner = new Scanner(System.in);
        float number = 0.0f;
        boolean input = false;
        while(!input){
            System.out.println("Введите вещественное число");
            try{
                number = iScanner.nextFloat();
                input = true;
            } catch (Exception e){
                iScanner.next();
                System.out.println("Попробуем ещё раз");s
            }
        }
        System.out.println(number);
        iScanner.close();
    }
}
