package HW_14;

import java.util.Scanner;

public class task_4 {
    
        public static void main(String[] args){
        Scanner iScanner = new Scanner(System.in);
        String str = iScanner.nextLine();
        if (str.length() == 0){
            throw new RuntimeException("Нельзя вводить пустые строки");
        } else {
            System.out.println("вы ввели не пустую строку: " + str);
        }
        iScanner.close();
    }
}
