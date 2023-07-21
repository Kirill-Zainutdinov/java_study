import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// в общем я понял как это всё работает
// да вообщ-то я и раньше знал, просто немножко синтаксис отличается от того же С++
// жалко нет времени, чтобы прям красивый какой-нибудь проект сделать

public class VetClinica {
    private final List<Animal> animals;
    private final List<Human> humans;

    public VetClinica() {
        this.animals = new ArrayList<>();
        this.humans = new ArrayList<>();
    }

    public VetClinica addNewAnimal(Animal animal){
        animals.add(animal);
        return this;
    }

    public VetClinica addNewHuman(Human human){
        humans.add(human);
        return this;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Animal> getFlyingAnimals(){
        List<Animal> resultAnimals = new ArrayList<>();
        for (Animal animal: animals) {
            if(animal instanceof Flyable){
                resultAnimals.add(animal);
                ((Flyable) animal).fly();
            }
        }
        return resultAnimals;
    }

    public List<Animal> getRunnebleAnimals(){
        List<Animal> resultAnimals = new ArrayList<>();
        for (Animal animal: animals) {
            if(animal instanceof Runnable){
                resultAnimals.add(animal);
                ((Runnable) animal).go();
            }
        }
        return resultAnimals;
    }

    public List<Animal> getSwimngAnimals(){
        List<Animal> resultAnimals = new ArrayList<>();
        for (Animal animal: animals) {
            if(animal instanceof Swimable){
                resultAnimals.add(animal);
                ((Swimable) animal).swim();
            }
        }
        return resultAnimals;
    }

    public List<Human> works(){
        List<Human> resultHumans = new ArrayList<>();
        for (Human human: humans) {
            if(human instanceof Cureble){
                resultHumans.add(human);
                ((Cureble) human).cure(animals.get(0));
            }
        }
        return resultHumans;
    }

    public int index = 0;


}
