package vitalkrilov.itmo.prog.lab4.entities;

import vitalkrilov.itmo.prog.lab4.exceptions.InventoryOverflowError;
import vitalkrilov.itmo.prog.lab4.exceptions.SlotAlreadyInUseException;
import vitalkrilov.itmo.prog.lab4.items.Takeable;
import vitalkrilov.itmo.prog.lab4.items.WearableItem;
import vitalkrilov.itmo.prog.lab4.world.Location;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

public class Hemulen extends Human {

    private final Map<OnBodyPosition, WearableItem> wearSlots;
    private static final int INVENTORY_CAPACITY = 20;
    private final List<Takeable> inventory;
    private HemulenPersonalRecords hemulenPersonalRecords;

    public Hemulen(Location loc) {
        super(loc, "Хемуль");
        this.wearSlots = new HashMap<>();
        this.inventory = new ArrayList<>();
        this.hemulenPersonalRecords = new HemulenPersonalRecords();
    }

    public HemulenPersonalRecords getHemulenPersonalRecords() {
        return this.hemulenPersonalRecords;
    }

    public void wear(OnBodyPosition targetSlot, WearableItem item) throws SlotAlreadyInUseException {
        if (this.wearSlots.containsKey(targetSlot))
            throw new SlotAlreadyInUseException();
        this.wearSlots.put(targetSlot, item);
        System.out.printf("%s надел %s в %s.%n", this.toString(), item.toString(), targetSlot.toString());
    }

    public void take(Takeable item) {
        if (inventory.size() == Hemulen.INVENTORY_CAPACITY) {
            throw new InventoryOverflowError();
        }
        item.notifyTakenBy(this);
        inventory.add(item);
        System.out.printf("%s взял %s.%n", this.toString(), item.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Hemulen o2 = (Hemulen) o;
        return Objects.equals(this.wearSlots, o2.wearSlots) && Objects.equals(this.inventory, o2.inventory) && Objects.equals(this.hemulenPersonalRecords, o2.hemulenPersonalRecords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.wearSlots, this.inventory, this.hemulenPersonalRecords);
    }

    @Override
    public String toString() {
        return String.format("Хемуль { %s, надетое=%s, инвентарь=%s, рекорды=%s }", super.toString(), this.wearSlots.toString(), this.inventory.toString(), this.hemulenPersonalRecords);
    }

}
