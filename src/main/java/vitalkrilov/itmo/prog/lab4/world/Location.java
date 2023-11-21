package vitalkrilov.itmo.prog.lab4.world;

import java.util.Objects;

public class Location {

    private final LocationType type;

    public Location(LocationType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        //if (!super.equals(o)) return false;
        Location o2 = (Location) o;
        return this.type == o2.type;
    }

    @Override
    public int hashCode() {
      return Objects.hash(super.hashCode(), this.type);
    }

    @Override
    public String toString() {
      return String.format("Локация { тип=%s }", this.type);
    }

}
