package Programmers입문;

import java.util.Arrays;
import java.util.Scanner;

public class ArrLength {
    public void solution(){
        String[] strlist = {"We","are","the","world!"};
        int[] answer = new int[strlist.length];
        for(int i=0;i< strlist.length;i++){
            answer[i]=strlist[i].length();
        }
        System.out.println(Arrays.toString(answer));

//        answer = Arrays.stream(strlist).mapToInt(String::length).toArray();

    }

    public static void main(String[] args) {
        ArrLength t = new ArrLength();
        t.solution();
    }


}
