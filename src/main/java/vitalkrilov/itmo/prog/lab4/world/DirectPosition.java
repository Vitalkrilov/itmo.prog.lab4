package vitalkrilov.itmo.prog.lab4.world;

import java.util.Objects;

public class DirectPosition extends Location {

    int positionID;
    private String commentary;
    private static int nextID = 1;

    public DirectPosition(String commentary) {
        super(LocationType.DIRECT_POSITION);
        this.positionID = nextID++;
        this.setCommentary(commentary);
    }

    public String getCommentary() {
        return this.commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DirectPosition o2 = (DirectPosition) o;
        return this.positionID == o2.positionID && Objects.equals(this.commentary, o2.commentary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.positionID, this.commentary);
    }

    @Override
    public String toString() {
        return String.format("Конкретная_позиция { %s, ID=%d, словесное_уточнение_позиции=\"%s\" }", super.toString(), this.positionID, this.commentary);
    }
}
