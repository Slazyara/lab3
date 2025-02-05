package roles;

public enum WoundStatus {
    BURNING("жгучая"),
    STRONG("сильная"),
    ACHING("ноющая");

    private String status;

    WoundStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
