package Programmers입문;

import java.util.Scanner;

public class locDot {

    public int solution(int[] dot){
        if(dot[0]>0&&dot[1]>0) return 1;
        if(dot[0]>0&&dot[1]<0) return 4;
        if(dot[0]<0&&dot[1]>0) return 2;
        if(dot[0]<0&&dot[1]<0) return 3;
        return 0;
    }

    public static void main(String[] args) {
        locDot t = new locDot();
        Scanner in = new Scanner(System.in);
        int[] dot = new int[2];
        dot[0]=in.nextInt();
        dot[1]=in.nextInt();
        System.out.println(t.solution(dot));
    }

}
