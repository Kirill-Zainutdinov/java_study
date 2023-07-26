package HW_9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
        public static void main(String[] args) {

                System.out.println("\n------------------------------");
                System.out.println("           HOME WORK");
                System.out.println("------------------------------");

                Pharmacy pharmacy1 = new Pharmacy();
                pharmacy1.addComponent(new Component("Peneciline", "0.6", 15))
                        .addComponent(new Component("Water", "1.2", 4));

                Pharmacy pharmacy2 = new Pharmacy();
                pharmacy2.addComponent(new Component("Peneciline", "0.6", 15))
                        .addComponent(new Component("Water", "1.2", 4));

                Pharmacy pharmacy3 = new Pharmacy();
                pharmacy3.addComponent(new Component("Peneciline", "0.6", 24))
                        .addComponent(new Component("Water", "1.2", 6));

                Pharmacy pharmacy4 = new Pharmacy();
                pharmacy4.addComponent(new Component("Peneciline", "0.6", 24))
                        .addComponent(new Component("Water", "1.2", 6));

                Pharmacy pharmacy5 = new Pharmacy();
                pharmacy5.addComponent(new Component("NatryChlorid", "0.6", 24))
                        .addComponent(new Component("Water", "1.2", 6));

                System.out.println(pharmacy1.equals(pharmacy2));
                System.out.println(pharmacy2.equals(pharmacy3));
                System.out.println(pharmacy3.equals(pharmacy4));
                System.out.println(pharmacy4.equals(pharmacy5));
                
                Set<Pharmacy> result = new HashSet<>();
                result.add(pharmacy1);
                result.add(pharmacy2);
                result.add(pharmacy3);
                result.add(pharmacy4);
                result.add(pharmacy5);

                System.out.println(pharmacy1.hashCode());
                System.out.println(pharmacy2.hashCode());
                System.out.println(pharmacy3.hashCode());
                System.out.println(pharmacy4.hashCode());
                System.out.println(pharmacy5.hashCode());
                System.out.println(result.size());

                System.out.println("\n------------------------------");
        }
}
