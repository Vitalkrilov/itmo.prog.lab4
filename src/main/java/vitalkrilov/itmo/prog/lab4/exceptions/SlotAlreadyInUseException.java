package vitalkrilov.itmo.prog.lab4.exceptions;

public class SlotAlreadyInUseException extends Exception {
    public String getDescription() {
        return "Выбранный слот уже занят другим предметом.";
    }
}
