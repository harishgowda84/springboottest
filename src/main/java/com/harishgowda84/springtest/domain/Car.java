package com.harishgowda84.springtest.domain;

public class Car {
    private String name;
    private String type;

    public Car(String carName, String carType) {
        name=carName;
        type=carType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
