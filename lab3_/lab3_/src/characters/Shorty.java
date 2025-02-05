package characters;

import authorities.Police;
import events.Command;
import exceptions.FullRocketException;
import items.Clothing;
import body.Injury;
import body.Wound;
import roles.Role;
import roles.WoundStatus;
import vehicles.Boardable;
import vehicles.HavingPassengers;
import vehicles.Person;
import vehicles.Rocket;
import weapons.Projectile;

public class Shorty extends Person {
    private Role role;
    private int health;
    private boolean isInjured;
    private boolean isInsideRocket;
    private Clothing clothing;
    private Wound wound;
    private boolean isSuffering;
    private WoundStatus pain;


    public Shorty(String name, Role role, Clothing clothing, MaxHealth startHealth) {
        super(name);
        this.role = role;
        this.health = startHealth.size();
        this.isInjured = false;
        this.isInsideRocket = false;
        this.clothing = clothing;
        this.isSuffering = false;
    }

    public void enterRocket(Boardable rocket) {
        if (!isInsideRocket) {
            int order = rocket.board(this);
            isInsideRocket = true;
            System.out.println(name + " залез в ракету " + order + "-ым.");
        } else {
            System.out.println(name + " уже находится в ракете.");
        }
    }

    public void exitRocket() {
        isInsideRocket = false;
        System.out.println(name + "вышел из ракеты");
    }

    public void getInjured(Injury injury) {
        this.isInjured = true;
        this.pain = pain;
        this.wound = new Wound(injury.getBodyPart(),injury.getPain(), injury.getSeverity());
        this.health -= injury.getDamage();
        clothing.addBloodStain();
        feelThePain(injury);

        System.out.println(name + " получает " + injury);
    }

    public void reactToCommand(Command command) {
        System.out.println(name + " выполняет команду: " + command.getDescription());
    }



    public void feelThePain(Injury injury) {
        if (this.isInjured) {
            System.out.println(name + " чувствует " + injury.getPain().getStatus() + " боль в " + injury.getBodyPart().getName());
        }
    }

    public boolean isInsideRocket() {
        return isInsideRocket;
    }

    public boolean isInjured() {
        return isInjured;
    }

    public Wound wound(){
        return wound;

    }

    public int getHealth() {
        return health;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Shorty)) return false;
        return ((this.isInjured == ((Shorty) obj).isInjured))
                & ((this.isInsideRocket == ((Shorty) obj).isInsideRocket))
                & ((this.isSuffering == ((Shorty) obj).isSuffering))
                & ((this.name == ((Shorty) obj).name))
                & ((this.role == ((Shorty) obj).role))
                & ((this.wound == ((Shorty) obj).wound))
                & ((this.clothing == ((Shorty) obj).clothing));

    }

    @Override
    public String toString(){
        return "Коротышка" + isInjured + " " + isInsideRocket + " " + isSuffering + " " + name + " " + role + " " + wound + " " + clothing;
    }

    @Override
    public int hashCode(){
        return (Boolean.valueOf(isInjured).hashCode()
                + Boolean.valueOf(isInsideRocket).hashCode()
                + String.valueOf(name).hashCode()
                + Boolean.valueOf(isSuffering).hashCode()
                + role.hashCode()
                + wound.hashCode()
                + clothing.hashCode());
    }

}

