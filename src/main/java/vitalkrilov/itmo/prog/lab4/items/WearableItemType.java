package vitalkrilov.itmo.prog.lab4.items;

public enum WearableItemType {

    CAP("Фуражка");

    private final String descriptiveName;

    WearableItemType(String descriptiveName) {
        this.descriptiveName = descriptiveName;
    }

    @Override
    public String toString() {
        return this.descriptiveName;
    }

}