package items;

public enum ClothingColor {
    WHITE("белый"),
    BLACK("чёрный"),
    RED("красный"),
    BLUE("синий"),
    GREEN("зелёный");

    private String colourName;

    ClothingColor(String colorName) {
        this.colourName = colorName;
    }

    public String getColorName() {
        return colourName;
    }
}
