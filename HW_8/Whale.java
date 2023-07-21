public class Whale extends Animal implements Swimable{

    public Whale(String name, String owner) {
        super(name, owner);
    }

    @Override
    public void swim(){
        System.out.println(this.getName()  + " плавёт к горизонту");
    }

    @Override
    public double getSpeed(){
        return 12.34;
    }
}
