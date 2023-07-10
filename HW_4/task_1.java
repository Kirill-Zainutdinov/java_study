package HW_4;

import java.util.LinkedList;
import java.util.Scanner;

public class task_1 {
    public static void main(String[] args) {
        
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите размер списка: ");
        int size = iScanner.nextInt();
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < size; i++) {
            list.add(iScanner.nextInt());
        }
        iScanner.close();
        list = ReverseList(list);
        System.out.println(list);
    }

    public static LinkedList<Integer> ReverseList(LinkedList<Integer> list){
        LinkedList<Integer> tmp = new LinkedList<Integer>();
        while(list.peekLast() != null){
            tmp.add(list.pollLast());
        }
        return tmp;
    }

}
