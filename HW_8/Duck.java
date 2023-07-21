public class Duck extends Animal implements Soundable, Flyable{
    public Duck(String name, String owner) {
        super(name, owner);
    }

    @Override
    public void sound() {
        System.out.println("krya");
    }

    @Override
    public void fly() {
        System.out.println(this.getName()  + " is flying");
    }

    @Override
    public double getSpeed(){
        return 5.6;
    }
}
