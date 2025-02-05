package body;

import roles.Severity;
import roles.WoundStatus;

public class Injury {
    private BodyPart bodyPart;
    private Severity severity;
    private WoundStatus pain;
    private int damage;

    public Injury(BodyPart bodyPart, WoundStatus pain, Severity severity) {
        this.bodyPart = bodyPart;
        this.severity = severity;
        this.pain = pain;
        this.damage = severity == Severity.LIGHT ? 10 : severity == Severity.MEDIUM ? 30 : 50;
    }

    public BodyPart getBodyPart(){return bodyPart;}
    public WoundStatus getPain(){
        return pain;
    }

    public Severity getSeverity() {
        return severity;
    }

    public int getDamage() {
        return damage;
    }
    @Override
    public String toString() {
        return "Ранение в " + bodyPart.getName() + " (" + severity + "). " +
                bodyPart.getDescription();
    }
}
