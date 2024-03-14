package org.example.calculate.util;

import org.example.calculate.enums.FavEnum;
import org.example.calculate.enums.FruitEnum;

public class ComputeUtil {

    public static Double compute(int appleWeight, int strawberryWeight, int mangoWeight, boolean isFav, String degree) {
        double total = 0D;
        double appleTotal = Math.abs(appleWeight) * FruitEnum.APPLE.getPrice();
        double strawberryTotal = Math.abs(strawberryWeight) * FruitEnum.STRAWBERRY.getPrice();
        double mangoTotal = Math.abs(mangoWeight) * FruitEnum.MANGO.getPrice();
        //如果有优惠
        if (isFav) {
            if (FavEnum.YES1.getDegree().equals(degree)) {
                strawberryTotal = strawberryTotal * 0.8;
                total = total + appleTotal + strawberryTotal + mangoTotal;
            } else if (FavEnum.YES2.getDegree().equals(degree)) {
                total = appleTotal + strawberryTotal + mangoTotal;
                if (total >= 100D) {
                    total = total - 10.0;
                }
            } else {
                total = appleTotal + strawberryTotal + mangoTotal;
            }
        } else {
            total = appleTotal + strawberryTotal + mangoTotal;
        }
        return total;
    }
}
