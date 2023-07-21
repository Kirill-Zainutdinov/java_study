public class Doctor extends Human implements Cureble {
    
    public Doctor(String _name){
        super(_name);
    }

    public Doctor(){
        this("");
    }

    @Override
    public void go(){
        System.out.printf("Я %s Иду лечить зверушку", this.name);
    }

    @Override
    public double getSpeed(){
        return 1.5;
    }

    @Override
    public void cure(Object animal){
        go();
        if (animal instanceof Animal){
            System.out.printf(" %s\n", ((Animal) animal).getName());
        }
    }
}
