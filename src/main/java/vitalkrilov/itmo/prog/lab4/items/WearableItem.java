package vitalkrilov.itmo.prog.lab4.items;

import vitalkrilov.itmo.prog.lab4.exceptions.CharacteristicAlreadyExistsException;

import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

public class WearableItem implements Takeable {

    private final WearableItemType type;
    private final Set<ItemCharacteristic> characteristics;

    public WearableItem(WearableItemType type) {
        this.type = type;
        this.characteristics = new HashSet<>();
    }

    public void addCharacteristic(ItemCharacteristic characteristic) {
        if (this.characteristics.contains(characteristic))
            throw new CharacteristicAlreadyExistsException();
        this.characteristics.add(characteristic);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        //if (!super.equals(o)) return false;
        WearableItem o2 = (WearableItem) o;
        return this.type == o2.type && Objects.equals(this.characteristics, o2.characteristics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.type, this.characteristics);
    }

    @Override
    public String toString() {
        return String.format("Надеваемый_предмет { тип=%s, характеристики=%s }", this.type.toString(), this.characteristics.toString());
    }

}
