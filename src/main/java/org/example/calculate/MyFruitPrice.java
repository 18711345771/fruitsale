package org.example.calculate;

import org.example.calculate.util.ComputeUtil;

import java.util.Scanner;

public class MyFruitPrice {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 创建Scanner对象来读取输入
        while (true) {
            System.out.println("欢迎购物，请输入所购水果的斤数：");

            System.out.println("苹果的斤数：");
            int appleWeight = scanner.nextInt(); // 读取整数

            System.out.println("草莓的斤数：");
            int strawberryWeight = scanner.nextInt(); // 读取整数

            System.out.println("芒果的斤数：");
            int mangoWeight = scanner.nextInt(); // 读取整数

            System.out.println("是否打折（1表示是，0表示否）：");
            int temp = scanner.nextInt(); // 读取整数

            boolean isDiscount = temp == 1 ? true : false;

            System.out.println("普通优惠还是大力优惠（1表示普通，2表示大力）：");
            int temp2 = scanner.nextInt(); // 读取整数

            String degree = temp2 == 1 ? "common" : (temp2 == 2 ? "great" : "");

            double total = ComputeUtil.compute(appleWeight, strawberryWeight, mangoWeight, isDiscount, degree);

            System.out.println(String.format("您购买苹果%d斤,草莓%d斤,芒果%d斤,共计%f元", Math.abs(appleWeight), Math.abs(strawberryWeight), Math.abs(mangoWeight), total));

            System.out.println("是否重新计算？（1表示是，0表示退出）");

            int nextResult = scanner.nextInt();

            if (nextResult == 0) {
                scanner.close(); // 关闭scanner
                break;
            } else if (nextResult == 1) {
                continue;
            }
        }
    }
}
