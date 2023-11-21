package vitalkrilov.itmo.prog.lab4.others;

public enum DayPart {

    SUNRISE("Восход"),
    MORNING("Утра"),
    NOON("Полдень"),
    AFTERNOON("День"),
    EVENING("Вечер"),
    NIGHT("Ночь");

    private final String descriptiveName;

    DayPart(String descriptiveName) {
        this.descriptiveName = descriptiveName;
    }

    @Override
    public String toString() {
        return this.descriptiveName;
    }

}
