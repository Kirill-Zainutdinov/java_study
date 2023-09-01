package HW_14;

import java.lang.reflect.Array;
import java.util.Scanner;

public class task_2 {
    public static void main(String[] args){
        int[] intArray = new int[100];
        // вообще тут можно поменять всё что угодно
        // а так код работает, что хотел автор никому не известно
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}
