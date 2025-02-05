package body;

import roles.Severity;
import roles.WoundStatus;

public class Wound {
    private BodyPart bodyPart;
    private Severity severity;
    private boolean isBleeding;
    private WoundStatus pain;

    public Wound(BodyPart bodyPart, WoundStatus pain, Severity severity) {
        this.bodyPart = bodyPart;
        this.severity = severity;
        this.isBleeding = true;
    }

    public void heal() {
        isBleeding = false;
        System.out.println("Рана на " + bodyPart.getName() + " зажила.");
    }

    public void worsen() {
        System.out.println("Рана на " + bodyPart.getName() + " ухудшилась.");
    }

    public BodyPart getBodyPart(){return bodyPart;}

    public Severity getSeverity() {
        return severity;
    }
    public WoundStatus getPain(){
        return pain;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Wound)) return false;
        return ((this.isBleeding == ((Wound) obj).isBleeding))
                & ((this.bodyPart == ((Wound) obj).bodyPart))
                & ((this.pain == ((Wound) obj).pain))
                & ((this.severity == ((Wound) obj).severity));

    }

    @Override
    public String toString(){
        return "Рана" + isBleeding + " " + bodyPart + " " + pain + " " + severity;
    }

    @Override
    public int hashCode(){
        return (Boolean.valueOf(isBleeding).hashCode()
                + bodyPart.hashCode()
                + pain.hashCode()
                + severity.hashCode());
    }
}
