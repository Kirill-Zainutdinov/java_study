package HW_7;

//Животное для вет. клиники
public class Animal implements Ilable {
    protected String nameAnimal; // Кличка животного
    protected String ownerName; // Имя хозяина
    protected String diagnosis;
    protected Boolean isVaccinated;
    protected final String TYPE = getClass().getSimpleName();

    public Animal(String animal, String ownerName, String diagnosis, Boolean isVaccinated) {
        this.nameAnimal = animal;
        this.ownerName = ownerName;
        this.diagnosis = diagnosis;
        this.isVaccinated = isVaccinated;
    }

    public Animal() {

    }

    public boolean isVaccinated() { // геттер для получения доступа к полю
        return this.isVaccinated;

    }

    public void setVaccinated(Boolean isVaccinated) { // сеттер для изменения поля
        this.isVaccinated = isVaccinated;

    }
    public String getType(){
        return TYPE;
    }

    @Override
    public String toString (){
        return String.format("%s{name = %s, owner = %s}", TYPE, nameAnimal, ownerName);
    }

    public String getType(String arg){
        return arg + TYPE;
    }

    protected void toGo (){
        System.out.println("Я умею бегать как " +  TYPE);
    }

    protected void sweem (){
        System.out.println("Я умею плавать как " + TYPE);
    }

    protected void fly (){
        System.out.println("Я умею летать как " + TYPE);
    }

    @Override
    public void ill() {
        System.out.println("Животное болеет");
    }
}
