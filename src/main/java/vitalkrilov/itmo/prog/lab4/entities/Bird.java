package vitalkrilov.itmo.prog.lab4.entities;

import vitalkrilov.itmo.prog.lab4.items.Droppable;
import vitalkrilov.itmo.prog.lab4.world.Location;

public class Bird extends LivingEntity {

    public Bird(Location loc) {
        super(loc);
    }

    public void flyAround() {
        System.out.printf("%s летит вокруг %s.%n", this.toString(), this.getCurrentLocation().toString());
    }

    public void dropItem(Droppable droppableItem) {
        droppableItem.makeDropped();
        System.out.printf("%s выбросила на землю %s.%n", this.toString(), droppableItem.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        return super.equals(o);
    }

    /*
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    */

    @Override
    public String toString() {
        return String.format("Птица { %s }", super.toString());
    }

}
