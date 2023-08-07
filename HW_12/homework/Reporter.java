package homework;

public class Reporter implements IReport{
    public void report(User us){
        System.out.println("Report for user: " + us.getName());
    }
}
