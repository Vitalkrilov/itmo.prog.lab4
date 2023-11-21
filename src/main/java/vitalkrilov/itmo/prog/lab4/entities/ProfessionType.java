
package vitalkrilov.itmo.prog.lab4.entities;

public enum ProfessionType {

    NONE("Без_профессии"),
    PRISON_WARDEN("Надзиратель_тюрьмы");

    private final String descriptiveName;

    ProfessionType(String descriptiveName) {
        this.descriptiveName = descriptiveName;
    }

    @Override
    public String toString() {
        return this.descriptiveName;
    }
}
