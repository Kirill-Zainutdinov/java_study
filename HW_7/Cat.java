package HW_7;

public class Cat extends Animal {
    
    Cat (String animal, String ownerName, String diagnosis, Boolean isVaccinated) {
        super(animal, ownerName, diagnosis, isVaccinated);
    }

    @Override
    protected void toGo(){
        System.out.println("Я умею ходить тихо и не заметно как " + TYPE);
    }

    @Override
    protected void sweem (){
        System.out.println("Я умею но не люблю плавать как " + TYPE);
    }

    @Override
    protected void fly (){
        System.out.println("Я не умею летать как " + TYPE);
    }
}
