package vitalkrilov.itmo.prog.lab4.exceptions;

public class ReceiverAlreadyRegisteredException extends RuntimeException {
    public String getDescription() {
        return "Этот получатель был уже выбран ранее.";
    }
}
