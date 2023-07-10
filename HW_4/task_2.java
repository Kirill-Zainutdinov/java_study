package HW_4;

import java.util.LinkedList;
import java.util.Scanner;

public class task_2 {
    public static void main(String[] args) {
        
        Scanner iScanner = new Scanner(System.in);

        LinkedList<Integer> list = new LinkedList<Integer>();
        
        System.out.println("Введите элемент, который надо поместить в конец очереди: ");
        int number = iScanner.nextInt();
        enqueue(list, number);
        iScanner.close();

        System.out.println("Возвращаем первый элемент из очереди не удаляя его: ");
        System.out.println(first(list));
        System.out.println(list);

        System.out.println("Возвращаем первый элемент из очереди и удаляем его: ");
        System.out.println(dequeue(list));
        System.out.println(list);
    }

    public static void enqueue(LinkedList<Integer> list, int number){
        list.addLast(number);
    }

    public static int dequeue(LinkedList<Integer> list){
        return list.pollFirst();
    }

    public static int first(LinkedList<Integer> list){
        return list.peekFirst();
    }

}
