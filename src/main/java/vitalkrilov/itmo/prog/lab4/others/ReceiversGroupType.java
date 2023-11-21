package vitalkrilov.itmo.prog.lab4.others;

public enum ReceiversGroupType {

    PRISONERS("Узники");

    private final String descriptiveName;

    ReceiversGroupType(String descriptiveName) {
        this.descriptiveName = descriptiveName;
    }

    @Override
    public String toString() {
        return this.descriptiveName;
    }

}
