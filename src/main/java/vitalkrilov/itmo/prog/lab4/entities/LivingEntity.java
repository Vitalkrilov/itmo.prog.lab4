package vitalkrilov.itmo.prog.lab4.entities;

import vitalkrilov.itmo.prog.lab4.others.Message;
import vitalkrilov.itmo.prog.lab4.world.Movable;
import vitalkrilov.itmo.prog.lab4.others.MessageReceivingCapable;
import vitalkrilov.itmo.prog.lab4.world.Location;

import java.util.Objects;

public abstract class LivingEntity implements Movable, MessageReceivingCapable {

    protected Location currentLocation;

    protected LivingEntity(Location loc) {
        this.setCurrentLocation(loc);
    }

    @Override
    public Location getCurrentLocation() {
        return this.currentLocation;
    }

    @Override
    public void setCurrentLocation(Location loc) {
        this.currentLocation = loc;
    }

    public void feel(FeelingType feelingType, String commentary) {
        System.out.printf("%s испытывает чувство %s%s.%n", this.toString(), feelingType.toString(), !commentary.isEmpty() ? ": " + commentary : "");
    }

    public void feel(FeelingType feelingType) {
        feel(feelingType, "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        //if (!super.equals(o)) return false;
        LivingEntity o2 = (LivingEntity) o;
        return Objects.equals(this.currentLocation, o2.currentLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.currentLocation.hashCode());
    }

    @Override
    public String toString() {
        return String.format("Живность { местоположение=%s }", this.currentLocation.toString());
    }

}
