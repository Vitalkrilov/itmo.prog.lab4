package vitalkrilov.itmo.prog.lab4.others;

public interface MessageReceivingCapable {

    default void receiveMessage(Message message) {
        System.out.printf("%s получил сообщение: %s.%n", this.toString(), message.toString());
    }

}