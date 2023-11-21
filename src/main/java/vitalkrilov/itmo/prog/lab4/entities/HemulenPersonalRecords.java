package vitalkrilov.itmo.prog.lab4.entities;

import vitalkrilov.itmo.prog.lab4.others.Date;

import java.util.Objects;

// Just data structure
public class HemulenPersonalRecords {
    public int maxPrisonersCountAtSameTime;
    public Date lastCompletedWardening;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HemulenPersonalRecords o2 = (HemulenPersonalRecords) o;
        return this.maxPrisonersCountAtSameTime == o2.maxPrisonersCountAtSameTime && Objects.equals(this.lastCompletedWardening, o2.lastCompletedWardening);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.maxPrisonersCountAtSameTime, this. lastCompletedWardening);
    }

    @Override
    public String toString() {
        return String.format("Персональные_рекорды_Хемуля { макс_количество_узников_за_все_время_его_работы=%s, дата_последней_завершенной_слежки_за_узниками=%s }", this.maxPrisonersCountAtSameTime, this.lastCompletedWardening);
    }
}