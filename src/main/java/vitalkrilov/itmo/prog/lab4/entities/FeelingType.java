package vitalkrilov.itmo.prog.lab4.entities;

public enum FeelingType {

    HAPPINESS("Счастье"),
    FEAR("Боязнь");

    private final String descriptiveName;

    FeelingType(String descriptiveName) {
        this.descriptiveName = descriptiveName;
    }

    @Override
    public String toString() {
        return this.descriptiveName;
    }
}
