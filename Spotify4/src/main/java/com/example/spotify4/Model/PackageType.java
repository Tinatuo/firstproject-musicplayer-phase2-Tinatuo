package com.example.spotify4.Model;

public enum PackageType {
    THIRTYDAYS(5),SIXTYDAYS(9),ONEHUNDREDEIGHTYDAYS(14);
    public double value;
    PackageType(double value){
        this.value=value;
    }

    public double getValue() {
        return value;
    }
}
