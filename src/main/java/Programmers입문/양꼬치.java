package Programmers입문;

import java.util.Scanner;

public class 양꼬치 {

    public int solution(int n, int k){
        // 양꼬치 1인분 12000, 음료수 2000
        int sumN = 12000*n;
        int sumK = 2000*k;
        int sum = sumN+sumK;
        int bonus = n/10;
        return sum-bonus*2000;
//        return 12000*n+2000*k-((n/10)*2000);

    }

    public static void main(String[] args) {

        양꼬치 T = new 양꼬치();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        System.out.println(T.solution(n,k));;
    }

}
