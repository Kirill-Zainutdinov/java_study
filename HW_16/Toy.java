package HW_16;

public class Toy {
    
    int id;
    int chance;
    String name;

    public Toy(int _id, int _chance, String _name) {
        id = _id;
        chance = _chance;
        name = _name;
    } 

    @Override
    public String toString() {
        return String.format("id = %s, chance = %s, name = %s", id, chance, name);
    }
}
