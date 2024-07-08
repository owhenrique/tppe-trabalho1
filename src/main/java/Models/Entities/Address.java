package Models.Entities;

import Models.Enums.EAddress;

public class Address {
    private String state;
    private EAddress isCapital;
    private String region;

    public Address(String state, EAddress isCapital, String region) {
        this.state = state;
        this.isCapital = isCapital;
        this.region = region;
    }

    // Getters

    public String getState() {
        return state;
    }

    public EAddress getIsCapital() {
        return isCapital;
    }

    public String getRegion() {
        return region;
    }

    // Setters

    public void setState(String state) {
        this.state = state;
        System.out.println("State set to: " + this.state);
    }

    public void setIsCapital(EAddress isCapital) {
        this.isCapital = isCapital;
        System.out.println("isCapital set to: " + this.isCapital);
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
