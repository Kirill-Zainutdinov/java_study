package HW_7;

import java.util.LinkedList;
import java.util.List;

public class HW_7 {
    
    public static void main(String[] args) {
        
        LinkedList<Animal> animals = new LinkedList<Animal>();

        animals.add(new Cat("Cat", "Vasya", "temperature", true));
        animals.add(new Eagle("Eagle", "Vasya", "temperature", false));
        animals.add(new Whale("Whale", "Vasya", "temperature", false));

        for(int i = 0; i < animals.size(); i++){
            System.out.printf("%s speek:\n", animals.get(i).getType());
            animals.get(i).toGo();
            animals.get(i).sweem();
            animals.get(i).fly();
            System.out.println("\n");
        }
    }
}
