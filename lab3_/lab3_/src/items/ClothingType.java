package items;

public enum ClothingType {
    SHIRT("рубашка"),
    JACKET("куртка"),
    PANTS("брюки"),
    HAT("шляпа");

    private String description;

    ClothingType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
