package model;

public class plans {

    public String planId;
    public String planDetails;
    public String cost;
    public String speed;


    public plans(String planId, String planDetails, String cost, String speed) {
        this.planDetails = planDetails;
        this.planId = planId;
        this.cost = cost;
        this.speed = speed;
    }
}
