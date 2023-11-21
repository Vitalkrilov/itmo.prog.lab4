package vitalkrilov.itmo.prog.lab4.items;

public enum ItemCharacteristic {

    POLICE("Полицейский");

    private final String descriptiveName;

    ItemCharacteristic(String descriptiveName) {
        this.descriptiveName = descriptiveName;
    }

    @Override
    public String toString() {
        return this.descriptiveName;
    }

}
