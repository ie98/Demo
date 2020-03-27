package com.exmaple.Demo.dto;

public class RecommendSit {
    private int sitNumber;
    private int distance;
    private Boolean use = true;

    public Boolean getUse() {
        return use;
    }

    public void setUse(Boolean use) {
        this.use = use;
    }


    public int getSitNumber() {
        return sitNumber;
    }

    public void setSitNumber(int sitNumber) {
        this.sitNumber = sitNumber;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "RecommendSit{" +
                "sitNumber=" + sitNumber +
                ", distance=" + distance +
                ", use=" + use +
                '}';
    }
}
