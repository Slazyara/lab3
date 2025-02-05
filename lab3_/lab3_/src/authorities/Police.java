package authorities;

import body.BodyPart;
import exceptions.PoliceNoAmmoException;
import vehicles.Person;
import weapons.Bullet;
import characters.Shorty;
import events.Event;
import body.Injury;
import roles.Severity;
import roles.WoundStatus;
import weapons.Projectile;

import java.util.Random;

public class Police {
    private int ammo;
    private boolean isShooting;
    private Shorty targetedShorty;
    private boolean readyToShoot;

    public Police(int ammo) {
        this.ammo = ammo;
        this.isShooting = false;
        this.readyToShoot = false;
    }

    public void readyToShoot() {
        readyToShoot = true;
        System.out.println("Полицейский готов стрелять!");
    }

    public void shoot(Person target, Projectile projectile,Injury injury) {
        if (!readyToShoot) return;
        if (ammo > 0) {
            isShooting = true;
            ammo--;
            System.out.println("Полицейский стреляет в " + target.getName());
            projectile.fly();

            if (Math.random() < 0.01) {
                projectile.hitTarget(target);
            }else {
                target.getInjured(new Injury(injury.getBodyPart(),injury.getPain(), injury.getSeverity()));
            }

            //
        } else {
            throw new PoliceNoAmmoException();
            //System.out.println("У полицейского закончились патроны.");
        }
        readyToShoot = false;
        isShooting = false;
    }

    public void triggerEvent(Event event) {
        System.out.println("Событие: " + event.getType());
        event.trigger();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Police)) return false;
        return ((this.isShooting == ((Police) obj).isShooting))
                & ((this.readyToShoot == ((Police) obj).readyToShoot))
                & ((this.ammo == ((Police) obj).ammo))
                & ((this.targetedShorty == ((Police) obj).targetedShorty));
    }

    @Override
    public String toString(){
        return "Полицейский" + isShooting + " " + readyToShoot + " " + ammo + " " + targetedShorty;
    }

    @Override
    public int hashCode(){
        return (Boolean.valueOf(isShooting).hashCode()
                + Boolean.valueOf(readyToShoot).hashCode()
                + Integer.valueOf(ammo).hashCode()
                + targetedShorty.hashCode());
    }
}
