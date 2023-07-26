package HW_9;

import java.util.Iterator;

public class ComponentIterator implements Iterator<Component>{

    private int index = 0;
    private Pharmacy pharmacy;

    public ComponentIterator(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
    
    @Override
    public boolean hasNext() {
        return index < pharmacy.getComponents().size();
    }

    @Override
    public Component next() {
        return pharmacy.getComponents().get(index++);
    }
}