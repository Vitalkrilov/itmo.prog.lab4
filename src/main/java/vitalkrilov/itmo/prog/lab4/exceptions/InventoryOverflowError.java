package vitalkrilov.itmo.prog.lab4.exceptions;

public class InventoryOverflowError extends RuntimeException {
    public String getDescription() {
        return "Выбранный инвентарь переполнен, и брать предмет некуда.";
    }
}
