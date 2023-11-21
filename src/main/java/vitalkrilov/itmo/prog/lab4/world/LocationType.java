package vitalkrilov.itmo.prog.lab4.world;

public enum LocationType {

    DIRECT_POSITION("Конкретная_позиция"),
    SOME_UNKNOWN_SCENE("Некоторая_неизвестная_сцена"),
    BAY("Залив"),
    FOREST("Лес"),
    SHORE("Берег"),
    MEADOW("Луг"),
    WATER("Вода"),
    HOUSE("Дом"),
    GARDEN("Сад"),
    JAIL("Тюрьма");

    private final String descriptiveName;

    LocationType(String descriptiveName) {
        this.descriptiveName = descriptiveName;
    }

    @Override
    public String toString() {
        return this.descriptiveName;
    }

}
