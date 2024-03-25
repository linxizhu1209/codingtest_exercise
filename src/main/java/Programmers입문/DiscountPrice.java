package Programmers입문;

import java.util.Scanner;

public class DiscountPrice {
    public int solution(int price){
        if(price>=500000) return (int)(price * 0.8);
        else if(price>=300000) return (int)(price * 0.9);
        else if(price>=100000) return (int)(price * 0.95);
        return price;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DiscountPrice t = new DiscountPrice();
        int price = in.nextInt();
        System.out.println(t.solution(price));
    }

}
