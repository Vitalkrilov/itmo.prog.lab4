package vitalkrilov.itmo.prog.lab4.others;

import vitalkrilov.itmo.prog.lab4.exceptions.ReceiverAlreadyRegisteredException;

import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

public class Message {

    private String content;
    private final Set<MessageReceivingCapable> receivers;

    public Message(String content) {
        this.receivers = new HashSet<>();
        this.setContent(content);
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void registerReceivers(MessageReceivingCapable receiver) {
        if (this.receivers.contains(receiver))
            throw new ReceiverAlreadyRegisteredException();
        this.receivers.add(receiver);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        //if (!super.equals(o)) return false;
        Message o2 = (Message) o;
        return Objects.equals(this.content, o2.content) && Objects.equals(this.receivers, o2.receivers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.content, this.receivers);
    }

    @Override
    public String toString() {
        return String.format("Сообщение { содержание=\"%s\", получатели=%s }", this.content, this.receivers.toString());
    }

}
