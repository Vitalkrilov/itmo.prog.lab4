package vitalkrilov.itmo.prog.lab4.world;

import java.util.Objects;

public class House extends Location {

    private final HouseLocationType subloc;

    public House(HouseLocationType subloc) {
        super(LocationType.HOUSE);
        this.subloc = subloc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        House o2 = (House) o;
        return this.subloc == o2.subloc;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.subloc);
    }

    @Override
    public String toString() {
        return String.format("Дом { %s, внутреннее_местоположение=%s }", super.toString(), this.subloc);
    }

}
