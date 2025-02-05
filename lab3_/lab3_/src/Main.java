import body.BodyPart;
import body.Injury;
import characters.*;
//import events.MoveToRocketCommand;
import events.MoveToRocketCommand;
import exceptions.FullRocketException;
import exceptions.PoliceNoAmmoException;
import items.Clothing;
import items.ClothingColor;
import items.ClothingType;
import roles.Role;
import roles.Severity;
import roles.WoundStatus;
import vehicles.Rocket;
import authorities.Police;
import weapons.Bullet;
import weapons.Projectile;

public class Main {
    public static void main(String[] args) {
        // Создание объектов
        MaxHealth maxHealth = new MaxHealth(100);
        Rocket rocket = new Rocket(5);
        Leader znaika = new Leader("Знайка", Role.LEADER, new Clothing(ClothingType.SHIRT, ClothingColor.WHITE), maxHealth);
        Shorty klepka = new Shorty("Клепка", Role.REGULAR, new Clothing(ClothingType.JACKET,ClothingColor.BLACK), maxHealth);
        Shorty fuxuy = new Shorty("Фуксия",Role.REGULAR, new Clothing(ClothingType.SHIRT,ClothingColor.BLUE), maxHealth);
        Shorty seld = new Shorty("Селедочка", Role.REGULAR, new Clothing(ClothingType.SHIRT, ClothingColor.WHITE), maxHealth);
        Doctor pilulkin = new Doctor("Пилюлькин", Role.DOCTOR, new Clothing(ClothingType.SHIRT,ClothingColor.BLUE), maxHealth);
        Police police = new Police(1);
        RescueHelper rescueHelper = new RescueHelper(znaika);

        police.readyToShoot();
        znaika.giveCommand(klepka, new MoveToRocketCommand());
        Projectile bullet = new Bullet(klepka.getName());

        try{
            police.shoot(klepka,bullet,new Injury(BodyPart.ARM, WoundStatus.BURNING, Severity.MEDIUM));

        } catch (PoliceNoAmmoException e){
            System.out.println(e.getMessage());
        }

        if (klepka.isInjured()) {
            pilulkin.go(klepka);
            pilulkin.evaluateInjury(klepka);
            pilulkin.treat(klepka);
        }

        rocket.openDoor();

        try {
            rescueHelper.dragIntoTheRocket(klepka, rocket);
        } catch (FullRocketException e) {
            System.out.println(e.getMessage());
        }
        try {
            fuxuy.enterRocket(rocket);
            seld.enterRocket(rocket);
            znaika.enterRocket(rocket);
        } catch (FullRocketException e) {
            System.out.println(e.getMessage());
        }
        rocket.closeDoor();
        rocket.launch();


    }
}
