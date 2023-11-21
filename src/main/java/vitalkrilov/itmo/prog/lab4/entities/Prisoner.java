package vitalkrilov.itmo.prog.lab4.entities;

import vitalkrilov.itmo.prog.lab4.world.Location;

import java.util.Objects;

public class Prisoner extends Human {

    private boolean isUnderLock;

    public Prisoner(Location loc) {
        super(loc, "Узник");
        this.isUnderLock = true;
    }

    @Override
    public void sit() {
        super.sit();
        System.out.printf("%s %sнаходится под замком.%n", this.toString(), this.isUnderLock ? "" : "не");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Prisoner o2 = (Prisoner) o;
        return this.isUnderLock == o2.isUnderLock;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.isUnderLock);
    }

    @Override
    public String toString() {
        return String.format("Узник { %s, под_замком=%s }", super.toString(), this.isUnderLock ? "да" : "нет");
    }

}
