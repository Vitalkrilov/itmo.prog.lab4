package vitalkrilov.itmo.prog.lab4.others;

import vitalkrilov.itmo.prog.lab4.items.Sendable;

public class Sender {

    public Sender() {
        //nothing here...
    }

    public void scheduleSending(Sendable item, Date sendOn) {
        System.out.printf("%s запланировал отправку %s на дату %s.%n", this.toString(), item.toString(), sendOn.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && this.getClass() == o.getClass();
    }

    /*
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    */

    @Override
    public String toString() {
        return "Неизвестный_отправитель";
    }

}
