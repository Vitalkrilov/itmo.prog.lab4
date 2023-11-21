package vitalkrilov.itmo.prog.lab4.entities;

import vitalkrilov.itmo.prog.lab4.others.Message;
import vitalkrilov.itmo.prog.lab4.world.Location;

import java.util.Objects;

public abstract class Human extends LivingEntity {

    private String name;
    private ProfessionType professionType;

    protected Human(Location loc, String name) {
        super(loc);
        this.name = name;
        this.professionType = ProfessionType.NONE;
    }

    public void sit() {
        System.out.printf("%s сидит.%n", this.toString());
    }

    public void sleep() {
        System.out.printf("%s спит.%n", this.toString());
    }

    public void suspect(Message msg) {
        System.out.printf("%s подозревает %s.%n", this.toString(), msg.toString());
    }

    public void whisper(String phrase) {
        System.out.printf("%s прошептал: \"%s\".%n", this.toString(), phrase);
    }

    public void think(String phrase) {
        System.out.printf("%s подумал: \"%s\".%n", this.toString(), phrase);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProfessionType getProfession() {
        return this.professionType;
    }

    public void setProfession(ProfessionType professionType) {
        this.professionType = professionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Human o2 = (Human) o;
        return Objects.equals(this.name, o2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.name);
    }

    @Override
    public String toString() {
        return String.format("\"%s\" <Человек> { %s }", this.name, super.toString());
    }

}
