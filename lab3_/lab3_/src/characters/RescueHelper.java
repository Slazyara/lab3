package characters;

import vehicles.Boardable;
import vehicles.HavingPassengers;
import vehicles.Rocket;
import exceptions.FullRocketException;

public class RescueHelper {
    private Shorty rescuer;

    public RescueHelper(Shorty rescuer) {
        this.rescuer = rescuer;
    }
    public void dragIntoTheRocket(Shorty shorty, Rocket rocket) {
        if (!shorty.isInsideRocket() && checkRocket(rocket)) {
            rocket.board(shorty);
            System.out.println(rescuer.getName() + " втащил " + shorty.getName() + " в ракету.");        } else {
            throw new FullRocketException();
        }
    }

    public boolean checkRocket(HavingPassengers rocket) {
        if (rocket.getPassengers().size() < rocket.getCapacity()) {
            return true;
        } else {
            return false;
        }
    }
}
