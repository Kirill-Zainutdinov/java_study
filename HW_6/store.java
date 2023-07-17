package HW_6;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

// тут конечно не совсем всё идеально и можжно было бы ещё пилить и пилить,
// но всё же работает)

public class store {
    
    static String[] manufacturers = new String[] {"HP", "Dell", "Asus", "Apple", "НПО Нижневартовский электротехнический комбинат"};
    static String symbols = "ABCDEFG-/123456";
    static String[] processors = new String[] {"AMD-1", "Intel-1", "Эльбрус-1", "AMD-2", "Intel-2", "Эльбрус-2"};
    static int[] RAMs = new int[] {2, 4, 8, 16, 32};
    static int[] memories = new int[] {500, 1000, 2000};
    static float[] displays = new float[] {15.1f, 17.5f, 19.1f, 21.0f};

    public static void main(String[] args) {
        
        Scanner iScanner = new Scanner(System.in);
        // мап с ноутбуками
        TreeMap<Integer, Notebook> notebooks = new TreeMap<>();
        // генирируем список ноутов
        for (int id = 0; id < 100; id++) {
            Notebook nb = new Notebook();
            nb.id = id;
            nb.manufacturer = manufacturers[(int)(Math.random() * 10) % 5];
            nb.model = "";
            for(int i = 0; i < 5; i ++){
                nb.model += symbols.charAt((int)(Math.random() * 100) % 15);
            }
            nb.processor = processors[(int)(Math.random() * 10) % 6];
            nb.RAM = RAMs[(int)(Math.random() * 10) % 5];
            nb.HDD = memories[(int)(Math.random() * 10) % 3];
            nb.display = displays[(int)(Math.random() * 10) % 4];
            nb.price = (float)Math.random() * 100000;
            notebooks.put(id, nb);
        }
        
        while (true){
            System.out.println("В нашем магазине предоставлены самые разнообразные модели компьютеров по самым разумным ценам!");
            System.out.println("Что будем делать?: ");
            System.out.println("1. Вывести список всех компов");
            System.out.println("2. Искать");
            System.out.println("3. С меня хватит");
            int choice = iScanner.nextInt();
            if (choice < 1 || 8 < choice) {
                System.out.println("Неправильный выбор");
            }
            else if (choice == 1){
                print(notebooks);
            }
            else if (choice == 2){
                find(notebooks);
            }
            else if(choice == 9){
                break;
            }
        }
        iScanner.close();
    }

    public static void find(TreeMap<Integer, Notebook> notebooks) {
        Scanner iScanner = new Scanner(System.in);
        // здесь сохраняется результат предыдущего поиска
        TreeMap<Integer, Notebook> lastResult = notebooks;
        // здесь сохраняется результат нового поиска
        TreeMap<Integer, Notebook> result = notebooks;

        // выбираем параметр, по которому производится поиск
        while(true){
            System.out.println("По какому критерию будем искать?");
            System.out.println("1. Искать по производителю");
            System.out.println("2. Искать по процессору");
            System.out.println("3. Искать по объёму RAM");
            System.out.println("4. Искать по объёму HDD");
            System.out.println("5. Искать по диагонали дисплея");
            System.out.println("6. Искать по цене");
            System.out.println("7. Выйти из меню поиска");

            int choice = iScanner.nextInt();
            if (choice < 1 || 7 < choice) {
                System.out.println("Неправильный выбор");
            }
            else if (choice == 1){
                result = findToManufacturer(lastResult);
            }
            else if (choice == 2){
                result = findToProcessor(lastResult);
            }
            else if (choice == 3){
                result = findToRAM(lastResult);
            }
            else if (choice == 4){
                result = findToHDD(lastResult);
            }
            else if (choice == 5){
                result = findToDisplay(lastResult);
            }
            else if (choice == 6){
                result = findToPrice(lastResult);
            }
            else if (choice == 7){
                break;
            }
            System.out.println("Результат поиска согласно выбранным параметрам:");
            print(result);

            choice = 0;
            while (choice < 1 && 3 > choice){
                System.out.println("Отменить последний фильтр ?");
                System.out.println("1. Да");
                System.out.println("2. Нет");
                System.out.println("3. Сбросить все фильтры");
                choice = iScanner.nextInt();
                if (choice < 1 || 2 < choice) {
                    System.out.println("Неправильный выбор");
                }
                else if (choice == 1){
                    // отменяем последний фльтр и возвращаемся к предыдущему результату
                    result = lastResult;
                }
                else if (choice == 2){
                    // сохраняем результат поиска по последнему фильтру
                    lastResult = result;
                }
                else if (choice == 3){
                    // сбрасываем все фильтры
                    lastResult = notebooks;
                }
            }
        }
    }
            

    public static void print(TreeMap<Integer, Notebook> notebookss) {
        for (var nb : notebookss.entrySet()){
            System.out.println(nb.getValue());
        }
    }

    public static TreeMap<Integer, Notebook> findToManufacturer(TreeMap<Integer, Notebook> notebooks) {
        Scanner iScanner = new Scanner(System.in);
        TreeMap<Integer, Notebook> result = new TreeMap<>();

        for(int i = 0; i < manufacturers.length; i ++){
            System.out.printf("%d. %s\n", i + 1, manufacturers[i]);
        }

        int choice = 0;
        while (choice < 1 || manufacturers.length < choice){
            System.out.printf("Введите ваш выбор от %d до %s\n", 1, manufacturers.length);
            choice = iScanner.nextInt();
        }
        String manufacturer = manufacturers[choice - 1];

        for (var item : notebooks.entrySet()){
            Notebook nb = item.getValue();
            if (nb.manufacturer == manufacturer){
                result.put(nb.id, nb);
            }
        }

        return result;
    }

    public static TreeMap<Integer, Notebook> findToProcessor(TreeMap<Integer, Notebook> notebooks) {
        Scanner iScanner = new Scanner(System.in);
        TreeMap<Integer, Notebook> result = new TreeMap<>();

        for(int i = 0; i < processors.length; i ++){
            System.out.printf("%d. %s\n", i + 1, processors[i]);
        }

        int choice = 0;
        while (choice < 1 || processors.length < choice){
            System.out.printf("Введите ваш выбор от %d до %s\n", 1, processors.length);
            choice = iScanner.nextInt();
        }
        String processor = processors[choice - 1];

        for (var item : notebooks.entrySet()){
            Notebook nb = item.getValue();
            if (nb.processor == processor){
                result.put(nb.id, nb);
            }
        }

        return result;
    }

    public static TreeMap<Integer, Notebook> findToRAM(TreeMap<Integer, Notebook> notebooks) {
        Scanner iScanner = new Scanner(System.in);
        TreeMap<Integer, Notebook> result = new TreeMap<>();

        System.out.println("Введите минимальный размер RAM");
        int min = iScanner.nextInt();
        System.out.println("Введите максимальный размер RAM");
        int max = iScanner.nextInt();

        for (var item : notebooks.entrySet()){
            Notebook nb = item.getValue();
            if (min <= nb.RAM && nb.RAM <= max){
                result.put(nb.id, nb);
            }
        }
        return result;
    }

    public static TreeMap<Integer, Notebook> findToHDD(TreeMap<Integer, Notebook> notebooks) {
        Scanner iScanner = new Scanner(System.in);
        TreeMap<Integer, Notebook> result = new TreeMap<>();

        System.out.println("Введите минимальный размер HDD");
        int min = iScanner.nextInt();
        System.out.println("Введите максимальный размер HDD");
        int max = iScanner.nextInt();

        for (var item : notebooks.entrySet()){
            Notebook nb = item.getValue();
            if (min <= nb.HDD && nb.HDD <= max){
                result.put(nb.id, nb);
            }
        }
        return result;
    }

    public static TreeMap<Integer, Notebook> findToDisplay(TreeMap<Integer, Notebook> notebooks) {
        Scanner iScanner = new Scanner(System.in);
        TreeMap<Integer, Notebook> result = new TreeMap<>();

        System.out.println("Введите минимальный размер диагонали");
        float min = iScanner.nextFloat();
        System.out.println("Введите максимальный размер диагонали");
        float max = iScanner.nextFloat();

        for (var item : notebooks.entrySet()){
            Notebook nb = item.getValue();
            if (min <= nb.display && nb.display <= max){
                result.put(nb.id, nb);
            }
        }
        return result;
    }

    public static TreeMap<Integer, Notebook> findToPrice(TreeMap<Integer, Notebook> notebooks) {
        Scanner iScanner = new Scanner(System.in);
        TreeMap<Integer, Notebook> result = new TreeMap<>();

        System.out.println("Введите минимальную цену");
        float min = iScanner.nextFloat();
        System.out.println("Введите максимальную цену");
        float max = iScanner.nextFloat();

        for (var item : notebooks.entrySet()){
            Notebook nb = item.getValue();
            if (min <= nb.price && nb.price <= max){
                result.put(nb.id, nb);
            }
        }
        return result;
    }
}
