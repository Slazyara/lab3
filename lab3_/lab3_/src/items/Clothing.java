package items;

public class Clothing {
    private ClothingType type;
    private ClothingColor color;
    private boolean isBloodStained;

    public Clothing(ClothingType type, ClothingColor color) {
        this.type = type;
        this.color = color;
        this.isBloodStained = false;
    }

    public void addBloodStain(){
        if (!isBloodStained){
            System.out.println("На " + color.getColorName() + " " + type.getDescription() +
                    " появилось красное пятно крови.");
            isBloodStained = true;
        }else{
            System.out.println("Пятна нет");
        }
    }

    public void clean(){
        if(isBloodStained){
            System.out.println("Одежда очищена от крови");
            isBloodStained = false;
        }else{
            System.out.println("Одежда уже чистая");
        }
    }

    @Override
    public String toString() {
        String condition = isBloodStained ? "с пятном крови" : "чистая";
        return color.getColorName() + " " + type.getDescription() + " (" + condition + ")";
    }
}
