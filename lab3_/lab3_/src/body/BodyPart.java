package body;

public enum BodyPart {
    ARM("рука", "Рана на руке ограничивает подвижность."),
    LEG("нога", "Рана на ноге затрудняет передвижение."),
    HEAD("голова", "Рана на голове может быть опасной для жизни."),
    CHEST("грудь", "Рана на груди серьёзно влияет на здоровье."),
    BACK("спина", "Рана на спине вызывает сильную боль.");

    private String name;
    private String description;

    BodyPart(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
