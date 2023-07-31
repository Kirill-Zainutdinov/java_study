package HW_9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Pharmacy implements Iterable<Component>, Comparable<Pharmacy>, Comparator<Pharmacy> {

    private List<Component> components;

    public Pharmacy() {
        this.components = new ArrayList<>();
    }

    public Pharmacy addComponent(Component component) {
        this.components.add(component);
        return this;
    }

    public List<Component> getComponents() {
        return components;
    }

    private int getPharmacyPower() {
        int power = 0;
        for (Component component : components) {
            power += component.getPower();
        }
        return power;
    }

    @Override
    public String toString() {
        return String.format("%s Состав: %s, сила: %s\n", getClass().getSimpleName(), this.components,
                this.getPharmacyPower());
    }

    @Override
    public Iterator<Component> iterator() {
        return new ComponentIterator(this);
    }

    @Override
    public int compareTo(Pharmacy other) {
        int dif = this.getPharmacyPower() - other.getPharmacyPower();
        if(dif != 0) return dif;
        // чем больше компанентов, тем больше Pharmacy
        dif = this.components.size() - other.components.size();
        if(dif != 0) return dif;
        // при одинаковой суммарной силе и одинаковом количестве, сравниваем по названиям
        StringBuilder stringBuilderThis = new StringBuilder();
        StringBuilder stringBuilderOther = new StringBuilder();
        for(int i = 0; i<this.components.size(); i++){
            stringBuilderThis.append(this.components.get(i).getName());
            stringBuilderOther.append(other.components.get(i).getName());
        }
        dif = stringBuilderThis.compareTo(stringBuilderOther);
        if (dif != 0) return dif;
        // получается составы одинаковы
        return 0;
    }

    @Override
    public int compare(Pharmacy o1, Pharmacy o2) {
        return o1.compareTo(o2);
    }

    @Override
    public boolean equals(Object obj) {
        // если это один тот же объект
        if (obj == this) {
            return true;
        }
        // если obj не на что нессылается или это вообще другой класс
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        // приводим к класс Pharmacy
        Pharmacy other = (Pharmacy)obj;
        // если количество компонентов разное
        if(this.components.size() != other.components.size()) return false;
        // сравниваем названия компонентов
        int globalMatch = 0;
        for (int i = 0; i < this.components.size(); i++) {
            int match = 0;
            for (int j = 0; j < other.components.size(); j++) {
                if(this.components.get(i).getName() == other.components.get(j).getName()){
                    match += 1;
                }
            }
            if (match != 1){
                return false;
            }
            else {
                globalMatch += 1;
            }
        }
        return this.components.size() == globalMatch;
    }

    @Override
    public int hashCode() {
        final int prime = 13131;
        int result = 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (Component component : components) {
            stringBuilder.append(component.getName()).append(component.getWeight());
            result += stringBuilder.toString().hashCode();
            stringBuilder.setLength(0);

            result += prime * component.getPower();
            result %= 1000000000;
        }

        return result;
    }
}