package Programmers입문;

import javax.swing.text.Style;
import java.util.Arrays;
import java.util.Scanner;

public class emergency {
    public int[] solution(int[] emergency){
        int[] answer = {};
        int[] arr = new int[emergency.length];
        for(int i=0;i<emergency.length;i++){
            int max=emergency[i];
            int count = 1;
            for(int j=0;j<emergency.length;j++){
                if(max<emergency[j]) count++;
            }
            arr[i] = count;
        }
        return arr;
    }

    public static void main(String[] args) {
        emergency t = new emergency();
        int[] e = {3,76,24};
        System.out.println(Arrays.toString(t.solution(e)));
    }

}
