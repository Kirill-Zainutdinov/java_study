package HW_10;

public class Main {
    
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();

        System.out.println("Добавляем элементы в конец...");
        list.addToEnd(10);
        list.addToEnd(20);
        list.addToEnd(30);

        System.out.println("Выводим список:");
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("\nДобавляем элементы в начало...");
        list.addToStart(40);
        list.addToStart(50);
        list.addToStart(60);

        System.out.println("Выводим список:");
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
