package backjoon;

import java.util.Scanner;

public class repeatString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0;i<T;i++){
            int R = in.nextInt();
            String S = in.next();
            for(char x:S.toCharArray()){
                System.out.print(String.valueOf(x).repeat(R));
            }
            System.out.println();
        }
    }
}
