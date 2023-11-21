package vitalkrilov.itmo.prog.lab4.others;

import java.util.Objects;

public class ReceiversGroup implements MessageReceivingCapable {

    private final ReceiversGroupType type;

    public ReceiversGroup(ReceiversGroupType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        //if (!super.equals(o)) return false;
        ReceiversGroup o2 = (ReceiversGroup) o;
        return this.type == o2.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.type);
    }

    @Override
    public String toString() {
        return String.format("Группа_получателей { тип=%s }", this.type.toString());
    }

}
