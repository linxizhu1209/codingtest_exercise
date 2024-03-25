package Programmers입문;

import java.util.Scanner;

public class createTriangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
//        for(int i=1;i<=n;i++){
//            System.out.println("*".repeat(i));
//        }
    }


}
