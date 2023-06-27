package Lection_1;
import java.util.Scanner;
public class program {
    public static void main(String[] args) {
        // считывание
        Scanner iScanner = new Scanner(System.in);
        String name = iScanner.nextLine();
        System.out.printf("Привет, %s", name);
        iScanner.close();


        int[][] arr = new int[3][5];

        for (int[] line : arr){
            for (int item: line){
                System.out.println(item);
            }
        }
        
    }
}