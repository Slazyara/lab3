package weapons;

public enum WeaponState {
    READY("готово к стрельбе"),
    ON_GUARD("на изготовку"),
    IDLE("неактивно");

    private String description;

    WeaponState(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
