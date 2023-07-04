package HW_3;

import java.util.Scanner;

public class task_2 {
    
    public static void main(String[] args) {
        
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = iScanner.nextInt();
        int[] array = new int[size];
        
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < array.length ; i++) {
            array[i] = iScanner.nextInt();
        }
        iScanner.close();

        printArray(deleteEvenNumbers(array));
    }

    public static int[] deleteEvenNumbers(int[] array){
        int even = 0;
        for (int i = 0; i < array.length; i++){
            if(array[i] % 2 == 0){
                even++;
            }
            else if(even > 0){
                array[i - even] = array[i];
            }
        }
        
        int[] result = new int[array.length - even];
        for (int i = 0; i < result.length; i++){
            result[i] = array[i];
        }

        return result;
    }

    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
}
