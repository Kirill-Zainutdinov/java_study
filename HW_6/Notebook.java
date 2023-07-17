package HW_6;

public class Notebook {
    
    int id;
    String manufacturer;
    String model;
    String processor;
    int RAM;
    int HDD;
    float display;
    float price;

    @Override
    public String toString() {
        return String.format(
            "id: %d, производитель: %s, модель: %s\nпроцессор: %s RAM: %d, HDD: %d, диагональ: %f\nцена: %f\n",
            id, manufacturer, model, processor, RAM, HDD, display, price
        );
    }
}
