package weapons;

import vehicles.Person;

public class Bullet implements Projectile {
    private String targetName;
    private boolean isActive;

    public Bullet(String targetName){
        this.isActive = true;
        this.targetName = targetName;
    }

    public void fly(){
        if (isActive){
            System.out.println("Пуля летит в " +targetName);
        }
    }

    public void hitTarget(Person target){
        if (isActive){
            isActive = false;
            System.out.println("Пуля попала в " + target.getName());
        }
    }

    public boolean isActive(){
        return isActive;
    }
}

