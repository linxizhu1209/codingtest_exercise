package backjoon.과제;

import java.util.Scanner;

public class star2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=n-i-1;j>=0;j--){
                System.out.print(" ");
            }
            System.out.print("*".repeat(i));
            System.out.println();
        }
    }
}