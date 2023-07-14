package HW_5;

import java.util.*;

public class task_1 {
    
    public static void main(String[] args) {
        phoneBook();
    }

    public static void phoneBook() {
        Scanner iScanner = new Scanner(System.in);
        Map<String, LinkedList<String>> pb = new HashMap<>();
        while (true){
            System.out.println("Что будем делать?: ");
            System.out.println("1. Добавить номер");
            System.out.println("2. Удалить номер");
            System.out.println("3. Вывести номер");
            System.out.println("4. Показать всю книгу");
            System.out.println("5. С меня хватит");
            int choice = iScanner.nextInt();
            if (choice < 1 || 5 < choice) {
                System.out.println("Неправильный выбор");
            }
            else if (choice == 1){
                addPhone(pb);
            }
            else if (choice == 2){
                delPhone(pb);
            }
            else if (choice == 3){
                getPhone(pb);
            }
            else if (choice == 4){
                printPhoneBook(pb);
            }
            else if (choice == 5){
                break;
            }
        }
        iScanner.close();
    }

    public static void addPhone(Map<String, LinkedList<String>> pb) {
        LinkedList<String> phones = new LinkedList<String>();
        Scanner iScanner_1 = new Scanner(System.in);
        String name, phone;

        System.out.println("Введите имя:");
        name = iScanner_1.nextLine(); 
        System.out.println("Введите телефон:");
        phone = iScanner_1.nextLine();

        if (pb.containsKey(name)){
            phones = pb.get(name);
        }
        phones.add(phone);
        pb.put(name, phones);

    }

    public static void delPhone(Map<String, LinkedList<String>> pb) {
        LinkedList<String> phones = new LinkedList<String>();
        Scanner iScanner = new Scanner(System.in);
        String name, phone;

        System.out.println("Введите имя:");
        name = iScanner.nextLine(); 
        System.out.println("Введите телефон:");
        phone = iScanner.nextLine();

        if (pb.containsKey(name)){
            phones = pb.get(name);
            if (phones.contains(phone)){
                phones.remove(phone);
                pb.put(name, phones);
            }
        }
    }

    public static void getPhone(Map<String, LinkedList<String>> pb) {
        LinkedList<String> phones = new LinkedList<String>();
        Scanner iScanner = new Scanner(System.in);
        String name;

        System.out.println("Введите имя:");
        name = iScanner.nextLine(); 

        if (pb.containsKey(name)){
            System.out.println(pb);
        }
    }

    // Я делал разные странные вещи, но это определённо одна из самых странных
    public static void printPhoneBook(Map<String, LinkedList<String>> pb) {

        LinkedList<Integer> sizes = new LinkedList<Integer>();
        Map<Integer, LinkedList<String>> sort = new HashMap<>();

        for (var item : pb.entrySet()) {
            LinkedList<String> keys = new LinkedList<String>();
            Integer size = item.getValue().size();

            if (!sizes.contains(size)){
                sizes.add(size);
            }

            if (sort.containsKey(size)){
                keys = sort.get(size);
            }

            keys.add(item.getKey());
            sort.put(size, keys);
        }

        sizes.sort(Comparator.reverseOrder());

        for (var s : sizes) {
            for (var k : sort.get(s)) {
                System.out.println(k);
                System.out.println(pb.get(k));
            }
        }
    }
}
