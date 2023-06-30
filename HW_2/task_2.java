package HW_2;

import java.util.logging.Logger;
import java.util.logging.ConsoleHandler;
import java.util.logging.SimpleFormatter;
import java.util.Scanner;

public class task_2 {
    public static void main(String[] args){
        int[] data = readArray();
        sort(data);
    }

    public static int[] readArray(){
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Укажите размер массива");
        int size =  iScanner.nextInt();
        int[] data = new int[size];
        System.out.println("Введите элементы массива");
        for(int i = 0; i < size; i++){
            data[i] = iScanner.nextInt();
        }
        iScanner.close();
        return data;
    }

    public static void sort(int[] data){
        Logger logger = Logger.getLogger(task_2.class.getName());
        ConsoleHandler ch = new ConsoleHandler();
        logger.addHandler(ch);
        SimpleFormatter sFormat = new SimpleFormatter();
        ch.setFormatter(sFormat);

        for(int i = 0; i < data.length - 1; i++){
            for(int j = 0; j < data.length - i - 1; j++){
                if(data[j] > data[j + 1]){
                    int tmp = data[j + 1];
                    data[j + 1] = data[j];
                    data[j] = tmp;
                }
            }
            StringBuilder result = new StringBuilder();
            for(int j = 0; j < data.length; j++){
                result.append(data[j]);
                result.append(" ");
            }
            String res = result.toString();
            logger.log(Level.INFO, res);
        }
    }
}
