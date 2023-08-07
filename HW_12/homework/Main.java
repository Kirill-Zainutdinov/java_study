package homework;

public class Main {
    public static void main(String[] args) {
//        User user = new User("Bob");
//        user.report();
//        user.save();

        User user = new User("Bob");
        Reporter userR = new Reporter();
        Persister userS = new Persister();
        userR.report(user);
        userS.save(user);

    }
}