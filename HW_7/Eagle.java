package HW_7;

public class Eagle extends Animal{
    
    Eagle (String animal, String ownerName, String diagnosis, Boolean isVaccinated) {
        super(animal, ownerName, diagnosis, isVaccinated);
    }

    @Override
    protected void toGo(){
        System.out.println("Я умею ходить как " + TYPE + " не зря же у меня ноги есть");
    }

    @Override
    protected void sweem (){
        System.out.println("Я не умею плавать как " + TYPE);
    }

    @Override
    protected void fly (){
        System.out.println("Я вообще лучше всех летаю я же " + TYPE);
    }
}
