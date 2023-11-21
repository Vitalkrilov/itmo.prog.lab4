package vitalkrilov.itmo.prog.lab4.world;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

public class WorldsWeatherTypesStorage {

    private final Map<Integer, WeatherType> weatherStatuses;

    public WorldsWeatherTypesStorage() {
        this.weatherStatuses = new HashMap<>();
    }

    public void setWeather(DirectPosition loc, WeatherType weather) {
        this.weatherStatuses.put(loc.positionID, weather);
    }

    public WeatherType getWeather(DirectPosition loc) {
        return this.weatherStatuses.get(loc.positionID);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        //if (!super.equals(o)) return false;
        WorldsWeatherTypesStorage o2 = (WorldsWeatherTypesStorage) o;
        return Objects.equals(this.weatherStatuses, o2.weatherStatuses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.weatherStatuses);
    }

    @Override
    public String toString() {
        return String.format("Хранилище_погоды_в_мировых_позициях { база_данных=%s }", this.weatherStatuses.toString());
    }

}
