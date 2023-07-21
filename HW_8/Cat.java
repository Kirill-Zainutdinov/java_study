public class Cat extends Animal implements Soundable, Runnable{
    public Cat(String name, String owner) {
        super(name, owner);
    }

    @Override
    public void sound() {
        System.out.println("Meow");
    }

    @Override
    public void go(){
        System.out.println(this.getName()  + " вальяжно идёт себе на уме");
    }

    @Override
    public double getSpeed(){
        return 4.5;
    }
}
