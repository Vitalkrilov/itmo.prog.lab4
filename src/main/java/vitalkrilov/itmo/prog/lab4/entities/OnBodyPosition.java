package vitalkrilov.itmo.prog.lab4.entities;

public enum OnBodyPosition {

    FOREHEAD("Лоб"),
    CHEST("Туловище"),
    BELT("Пояс"),
    LEGS("Ноги"),
    FEET("Ступни");

    private final String descriptiveName;

    OnBodyPosition(String descriptiveName) {
        this.descriptiveName = descriptiveName;
    }

    @Override
    public String toString() {
        return this.descriptiveName;
    }
}
