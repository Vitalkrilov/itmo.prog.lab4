package vitalkrilov.itmo.prog.lab4.items;

import vitalkrilov.itmo.prog.lab4.entities.LivingEntity;

public interface Takeable {

    default void notifyTakenBy(LivingEntity entity) {}

}
