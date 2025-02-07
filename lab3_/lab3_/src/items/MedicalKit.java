package items;

import characters.Shorty;
import roles.WoundStatus;

public class MedicalKit {
    private static final int HEAL_AMOUNT = 50;

    public void heal(Shorty target) {
        if (target.getHealth() <= 0) {
            System.out.println("Врач использует аптечку, чтобы спасти " + target.getName());
            target.setHealth(HEAL_AMOUNT);
            System.out.println(target.getName() + " спасён! Здоровье восстановлено до " + HEAL_AMOUNT);
        } else {
            System.out.println("Аптечка не нужна: " + target.getName() + " ещё жив.");
        }
    }
}