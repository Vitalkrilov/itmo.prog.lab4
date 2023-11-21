package vitalkrilov.itmo.prog.lab4.items;

public enum PosterType {

    THEATRICAL("Театральная");

    private final String descriptiveName;

    PosterType(String descriptiveName) {
        this.descriptiveName = descriptiveName;
    }

    @Override
    public String toString() {
        return this.descriptiveName;
    }

}
