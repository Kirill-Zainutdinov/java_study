package homework;

public class Persister implements IPersister{
    public void save(User us){
        System.out.println("Save user: " + us.getName());
    }
}
