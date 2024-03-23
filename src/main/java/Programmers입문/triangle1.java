package Programmers입문;

import java.util.Arrays;
import java.util.Scanner;

public class triangle1 {

    public int solution(int[] sides){
        int answer = 0;
//        answer = Arrays.stream(sides).max().orElse(0)>= Arrays.stream(sides).asDoubleStream().sum()/2?2:1;
        Arrays.sort(sides);
        answer = sides[2]>=sides[0]+sides[1]?2:1;
        return answer;
    }

    public static void main(String[] args) {
        triangle1 t = new triangle1();
        Scanner in = new Scanner(System.in);
        int[] sides = new int[3];
        for(int i=0;i<3;i++){
            sides[i]=in.nextInt();
        }
        System.out.println(t.solution(sides));
    }

}
