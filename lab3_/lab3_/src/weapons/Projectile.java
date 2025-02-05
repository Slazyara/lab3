package weapons;

import vehicles.Person;

public interface Projectile {
    void fly();
    void hitTarget(Person target);
    boolean isActive();
}
