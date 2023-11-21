package vitalkrilov.itmo.prog.lab4.world;

public enum WeatherType {

    CLEAR("Ясная"),
    SUNNY("Солнечная"),
    PARTLY_SUNNY("Переменная_солнечная"),
    PARTLY_CLOUDY("Переменная_облачность"),
    SUN_AND_RAIN("Солнечная_с_дождём"),
    RAINING("Дождливая"),
    THUNDERSTORMS("Гроза"),
    SNOWING("Снег"),
    CLOUDY("Облачная"),
    WINDY("Ветреная"),
    RAINBOW("Радуга"),
    TORNADOES_OR_HURRICANES("Торнадо_или_ураган");

    private final String descriptiveName;

    WeatherType(String descriptiveName) {
        this.descriptiveName = descriptiveName;
    }

    @Override
    public String toString() {
        return this.descriptiveName;
    }

}