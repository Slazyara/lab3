package vehicles;

import exceptions.FullRocketException;

import java.util.ArrayList;
import java.util.List;

public class Rocket implements Boardable, HavingPassengers {
    private int capacity;
    private List<Person> passengers;
    private boolean isDoorClosed;
    private boolean isReadyToLaunch;

    public Rocket(int capacity) {
        this.capacity = capacity;
        this.passengers = new ArrayList<>();
        this.isDoorClosed = false;
        this.isReadyToLaunch = false;
    }

    public int board(Person shorty) {
        if (passengers.size() < capacity) {
            passengers.add(shorty);
            return passengers.size();
        } else {
            throw new FullRocketException();
        }
    }

    public void closeDoor() {
        isDoorClosed = true;
        System.out.println("Дверь ракеты закрыта.");
    }

    public void openDoor() {
        isDoorClosed = false;
        System.out.println("Дверь ракеты открыта");
    }

    public void launch() {
        if (isDoorClosed && !passengers.isEmpty()) {
            isReadyToLaunch = true;
            System.out.println("Ракета запущена!");
        } else {
            System.out.println("Ракета не готова к запуску.");
        }
    }

    public void checkPassengerState() {
        for (Person passenger : passengers) {
            System.out.println(passenger.getName() + " здоровье: " + passenger.getHealth());
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Person> getPassengers() {
        return passengers;
    }

    public int getPassengerCount() {
        return passengers.size();

    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Rocket)) return false;
        return ((this.capacity == ((Rocket) obj).capacity)
                & (this.isDoorClosed == ((Rocket) obj).isDoorClosed)
                & (this.passengers == ((Rocket) obj).passengers)
                & (this.isReadyToLaunch == ((Rocket) obj).isReadyToLaunch));
    }

    @Override
    public String toString() {
        return "Ракета " + capacity  + " " + isReadyToLaunch + " " + isDoorClosed + " " + passengers;
    }

    @Override
    public int hashCode() {
        return (passengers.hashCode()
                + Integer.valueOf(capacity).hashCode()
                + Boolean.valueOf(isDoorClosed).hashCode()
                + Boolean.valueOf(isReadyToLaunch).hashCode());
    }
}
