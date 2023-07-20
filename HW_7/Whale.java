package HW_7;

public class Whale extends Animal{
    
    Whale (String animal, String ownerName, String diagnosis, Boolean isVaccinated) {
        super(animal, ownerName, diagnosis, isVaccinated);
    }

    @Override
    protected void toGo(){
        System.out.println("Я не умею ходить, я же " + TYPE);
    }

    @Override
    protected void sweem (){
        System.out.println("Я плаваю лучше всех, я же " + TYPE);
    }

    @Override
    protected void fly (){
        System.out.println("Я не умею летать я же " + TYPE);
    }
}
