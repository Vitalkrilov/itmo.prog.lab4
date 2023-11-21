package vitalkrilov.itmo.prog.lab4.others;

import java.util.Objects;

public class Date {
    private final DayPart dayPart;
    private final int dayNumber;
    private static int storyStartDayNumber;

    public Date(DayPart part, int dayNumber) {
        this.dayPart = part;
        this.dayNumber = dayNumber;
    }

    public static int getStoryStartDayNumber() {
        return storyStartDayNumber;
    }

    public static void setStoryStartDayNumber(int dayNumber) {
        storyStartDayNumber = dayNumber;
    }

    public int getDayNumber() {
        return this.dayNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        //if (!super.equals(o)) return false;
        Date o2 = (Date) o;
        return this.dayPart == o2.dayPart && this.dayNumber == o2.dayNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.dayPart, this.dayNumber);
    }

    @Override
    public String toString() {
        return String.format("Дата { часть_дня=%s, порядковый_день_с_начала_истории=%d }", this.dayPart.toString(), this.dayNumber);
    }
}
