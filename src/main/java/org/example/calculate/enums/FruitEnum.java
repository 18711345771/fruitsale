package org.example.calculate.enums;

public enum FruitEnum {
    APPLE("苹果", 8.0),
    STRAWBERRY("草莓", 13.0),
    MANGO("芒果", 20.0),
    ;
    private String name;
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    FruitEnum(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public static FruitEnum getInstance(String name) {
        for (FruitEnum value : FruitEnum.values()) {
            if (value.getName().equals(name)) {
                return value;
            }
        }
        return null;
    }

}
