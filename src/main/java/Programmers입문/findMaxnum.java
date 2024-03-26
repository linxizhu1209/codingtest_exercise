package Programmers입문;

import java.util.Arrays;
import java.util.Scanner;

public class findMaxnum {

    public int[] solution(int[] array){
        int max = Integer.MIN_VALUE;
        int[] answer = new int[2];
        for(int i=0;i<array.length;i++){
            if(array[i]>max){
                answer[0]=array[i];
                answer[1]=i;
                max=array[i];
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        findMaxnum t = new findMaxnum();
        int[] arr = {9,10,11,8};
        System.out.println(Arrays.toString(t.solution(arr)));
    }
}
