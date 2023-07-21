import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) {
        VetClinica clinic = new VetClinica();
        clinic
        .addNewAnimal(new Cat("Barsik", "Nikolai"))
        .addNewAnimal(new Dog("Pushok", "Oleg"))
        .addNewAnimal(new Duck("Kriakva", "Oleg"))
        .addNewAnimal(new Duck("Kluvik", "Oleg"))
        .addNewAnimal(new Whale("Whille", "Oleg"))
        .addNewAnimal(new Whale("Bille", "Oleg"));

        clinic
        .addNewHuman(new Doctor("Ivan Ivanovich"))
        .addNewHuman(new Doctor("Lazar Moiseevich"))
        .addNewHuman(new Nurse("Maria Petrovna"))
        .addNewHuman(new Nurse("Galina Ivanovna"));
    
        List<Animal> flying = clinic.getFlyingAnimals();
        List<Animal> running = clinic.getRunnebleAnimals();
        List<Animal> swimming = clinic.getSwimngAnimals();

        List<Human> humans = clinic.works();
    }
}
