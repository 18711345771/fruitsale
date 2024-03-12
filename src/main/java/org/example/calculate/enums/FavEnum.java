package org.example.calculate.enums;

public enum FavEnum {
    //草莓限时打 8 折
    YES1(true,"common"),
    //购物满 100 减 10 块
    YES2(true,"great"),
    //不优惠
    NO(false,""),
    ;
    private boolean fav;

    private String degree;

    public boolean isFav() {
        return fav;
    }

    public void setFav(boolean fav) {
        this.fav = fav;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    FavEnum(boolean fav, String degree) {
        this.fav = fav;
        this.degree = degree;
    }
}
