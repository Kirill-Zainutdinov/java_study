package HW_3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class task_3 {
    
    public static void main(String[] args) {

        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите размер списка: ");
        int size = iScanner.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>(size);
        System.out.println("Введите элементы списка: ");
        for (int i = 0; i < size ; i++) {
            list.add(iScanner.nextInt());
        }
        iScanner.close();

        System.out.println(findMin(list));
        System.out.println(findMax(list));
        // не совсем понял, что имеется в виду под средним
        // по этому вот две функции с разным функционалом
        System.out.println(findMean_1(list));
        System.out.println(findMean_2(list));
    }

    public static int findMin(ArrayList<Integer> list) {
        int min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
            }
        }
        return min;
    }

    public static int findMax(ArrayList<Integer> list) {
        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }
    
    public static int findMean_1(ArrayList<Integer> list) {
        Collections.sort(list);
        return list.get(list.size()/2);
    }

    public static double findMean_2(ArrayList<Integer> list) {
        int summ = 0;
        for (int i = 0; i < list.size(); i++) {
            summ += list.get(i);
        }
        return (double)summ / list.size();
    }
}
