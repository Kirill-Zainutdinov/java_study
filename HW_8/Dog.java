public class Dog extends Animal implements Soundable, Illable, Runnable {
    public Dog(String name, String owner) {
        super(name, owner);
    }

    @Override
    public void sound() {
        System.out.println("bark");
    }

    @Override
    public void go(){
        System.out.println(this.getName() + " Бежит виляя хвостом");
    }

    @Override
    public double getSpeed(){
        return 3.4;
    }
}
