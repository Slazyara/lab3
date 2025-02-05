package characters;

import items.Clothing;
import body.Injury;
import items.MedicalKit;
import roles.Role;

public class Doctor extends Shorty {
    private MedicalKit medicalKit;
    private boolean isTreating;

    public Doctor(String name, Role role, Clothing clothing, MaxHealth startHealth){
        super(name, role, clothing, startHealth);
        this.medicalKit = new MedicalKit();
        this.isTreating = false;
    }

    public void go(Shorty target) {
        System.out.println(name + " бросился к " + target.getName() + " со своей аптечкой.");
    }

    public void treat(Shorty target){
        if (target.isInjured()){
            isTreating=true;
            System.out.println(name + " начал лечить " + target.getName());
            stopBleeding(target);
            applyBandage(target);
            isTreating = false;
        }
    }
    public void stopBleeding(Shorty target){
        target.wound().heal();
        System.out.println(name + " остановил кровотечение у " + target.getName());
    }
    public void applyBandage(Shorty target){
        System.out.println(name + " наложил повязку на рану " + target.getName());
    }
    public Injury evaluateInjury(Shorty target) {
        System.out.println(name + " оценил ранение у " + target.getName());
        return target.wound() != null ? new Injury(target.wound().getBodyPart(), target.wound().getPain() ,target.wound().getSeverity()) : null;
    }
}
