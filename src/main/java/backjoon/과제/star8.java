package backjoon.과제;

import java.util.Scanner;

public class star8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=1;i<=n;i++){
             System.out.print("*".repeat(i));
             System.out.print(" ".repeat(n-i));
             System.out.print(" ".repeat(n-i));
             System.out.print("*".repeat(i));
             System.out.println();
        }
        for(int i=n-1;i>=1;i--){
            System.out.print("*".repeat(i));
            System.out.print(" ".repeat(n-i));
            System.out.print(" ".repeat(n-i));
            System.out.print("*".repeat(i));
            System.out.println();
        }
    }
}
