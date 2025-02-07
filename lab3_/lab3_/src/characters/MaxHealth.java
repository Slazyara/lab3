package characters;

public record MaxHealth(int size) {
    public MaxHealth {
        if (size <= 0) {
            throw new IllegalArgumentException("Здоровье должно быть строго больше нуля.");
        }
    }
}