package vitalkrilov.itmo.prog.lab4.world;

public enum HouseLocationType {

    ROOF("Крыша");

    private final String descriptiveName;

    HouseLocationType(String descriptiveName) {
        this.descriptiveName = descriptiveName;
    }

    @Override
    public String toString() {
        return this.descriptiveName;
    }
  
}
