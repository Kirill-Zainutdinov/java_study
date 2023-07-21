public class Nurse extends Human implements Cureble {
    public Nurse(String _name){
        super(_name);
    }

    public Nurse(){
        this("");
    }

    @Override
    public void go(){
        System.out.printf("Я %s Иду помогать доктору лечить зверушку", this.name);
    }

    @Override
    public double getSpeed(){
        return 2.0;
    }

    @Override
    public void cure(Object animal){
        go();
        if (animal instanceof Animal){
            System.out.printf(" %s\n", ((Animal) animal).getName());
        }
    }
}
