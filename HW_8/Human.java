public class Human implements Runnable{

    protected String name;

    static protected int count;

    static {
        count = 0;
    }

    public Human(String _name){
        count++;
        if (_name == "") {
            this.name = "NoName_" + Integer.toString(count);
        }
        else {
            this.name = _name;
        }
    }

    public Human(){
        this("");
    }

    public String getName(){
        return this.name;
    }

    @Override
    public void go(){
        System.out.println("Иду-иду...");
    }

    @Override
    public double getSpeed(){
        return 1;
    }
}
