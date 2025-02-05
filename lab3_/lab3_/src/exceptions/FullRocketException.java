package exceptions;

public class FullRocketException extends RuntimeException {
    public FullRocketException() {
        super("Ракета переполнена, свободных мест нет!");
    }

    @Override
    public String getMessage() {
        return "Ракета переполнена, свободных мест нет!";
    }
}
