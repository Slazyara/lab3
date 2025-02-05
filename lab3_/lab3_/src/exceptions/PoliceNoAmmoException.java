package exceptions;

public class PoliceNoAmmoException extends RuntimeException {
    public PoliceNoAmmoException() {
        super("У полицейского не хватает патронов для стрельбы.");
    }

    @Override
    public String getMessage(){return  "У полицейского не хватает патронов для стрельбы.";}
}
