package vitalkrilov.itmo.prog.lab4.items;

import vitalkrilov.itmo.prog.lab4.entities.LivingEntity;
import vitalkrilov.itmo.prog.lab4.world.Location;
import vitalkrilov.itmo.prog.lab4.world.Movable;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Poster implements Sendable, InAirSpinnable, Droppable, Movable, Takeable {

    private String storyNameAlias;
    private final List<String> authors;
    private boolean colorful;
    private final PosterType type;
    private Location currentLocation;
    private boolean sent;
    private boolean dropped;

    private final static String defaultStoryNameAlias = "Афиша";

    public Poster(PosterType type, Location loc) {
        this.type = type;
        this.setCurrentLocation(loc);
        this.authors = new ArrayList<>();
        this.storyNameAlias = defaultStoryNameAlias;
    }

    public void fallTo(Location loc) {
        this.setCurrentLocation(loc);
        System.out.printf("%s упал в %s.%n", this.toString(), loc.toString());
    }

    public String getStoryNameAlias() {
        return this.storyNameAlias;
    }

    public void setStoryNameAlias(String storyNameAlias) {
        this.storyNameAlias = storyNameAlias;
    }

    public void addAuthor(String author) {
        this.authors.add(author);
    }

    public boolean isColorful() {
        return this.colorful;
    }

    public void setColorful(boolean state) {
        this.colorful = state;
    }

    @Override
    public void makeSent() {
        this.sent = true;
    }

    @Override
    public void spinInAirAround() {
        System.out.printf("%s кружится в воздухе около %s.%n", this.toString(), this.getCurrentLocation().toString());
    }

    @Override
    public void makeDropped() {
        this.dropped = true;
    }

    @Override
    public Location getCurrentLocation() {
        return this.currentLocation;
    }

    @Override
    public void setCurrentLocation(Location loc) {
        this.currentLocation = loc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        //if(!super.equals(o)) return false;
        Poster o2 = (Poster) o;
        return Objects.equals(this.authors, o2.authors) && this.colorful == o2.colorful && Objects.equals(this.storyNameAlias, o2.storyNameAlias) && this.type == o2.type && Objects.equals(this.currentLocation, o2.currentLocation) && this.sent == o2.sent && this.dropped == o2.dropped;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.authors, this.colorful, this.storyNameAlias, this.type, this.currentLocation, this.sent, this.dropped);
    }

    @Override
    public String toString() {
        return String.format("%s { авторы=%s, %s, тип=%s, местоположение=%s, был_отправлен=%s, был_брошен=%s }", this.storyNameAlias.equals(defaultStoryNameAlias) ? defaultStoryNameAlias : String.format("\"%s\" <%s>", this.storyNameAlias, defaultStoryNameAlias), this.authors.toString(), this.colorful ? "цветная" : "не особо цветная", this.type.toString(), this.currentLocation.toString(), this.sent ? "да" : "нет", this.dropped ? "да" : "нет");
    }

}
