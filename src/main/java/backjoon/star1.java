package backjoon;

import java.util.Scanner;

public class star1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i=1;i<=n;i++){
            System.out.print("*".repeat(i));
            System.out.println();
        }
    }
}
