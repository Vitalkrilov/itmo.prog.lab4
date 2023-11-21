package vitalkrilov.itmo.prog.lab4.exceptions;

public class CharacteristicAlreadyExistsException extends RuntimeException {
    public String getDescription() {
        return "Характеристика уже была присвоена ранее.";
    }
}
