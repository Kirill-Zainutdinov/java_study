package HW_16;

import HW_16.Toy;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;


public class Shop {
    
    public static void main(String[] args){

        int[] ids = new int[3];
        int[] chances = new int[3];
        String[] names = new String[3];

        for(int i = 0; i < 3; i++){
            String[] parametrs = readParametrs();
            ids[i] = Integer.parseInt(parametrs[0]);
            chances[i] = Integer.parseInt(parametrs[1]);
            names[i] = parametrs[2];
        }

        PriorityQueue<Toy> toys = new PriorityQueue<Toy>();
        for(int i = 0; i < 10; i++){
            //int id = get(chances);
            int id = 1;
            toys.add(new Toy(id, chances[id - 1], names[id - 1]));
        }

        while(toys.size() > 0){
            toys.remove();
        }
    }

    public static String[] readParametrs(){
        Scanner iScanner = new Scanner(System.in);
        String str = iScanner.nextLine();
        iScanner.close();
        return str.split(" ");
    }

    public int get(int[] chances){
        Random random = new Random();
        int id = 0;
        int point0 = 1;
        int point1 = chances[0];
        int point2 = chances[0] + chances[1];
        int point3 = 100;

        int rand = random.nextInt(1, 101);
        if (point0 <= rand && rand <= point1) {
            id = 1;
        }
        else if (point1 < rand && rand <= point2) {
            id = 2;
        }
        else if (point2 < rand && rand <= point3) {
            id = 3;
        }
        return id;
    }

    public static void write(Toy toy) {
        try(FileWriter writer = new FileWriter("toysbase.txt", true)) { 
            writer.write(toy + "\n");
        } 
        catch(IOException e){ 
            throw new RuntimeException("Проблемы с записью в файл " + e);
        } 
    }
}
