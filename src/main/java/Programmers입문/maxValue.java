package Programmers입문;

import java.util.Arrays;

public class maxValue {
    public int solution(int[] numbers){
        Arrays.sort(numbers);
        int length = numbers.length;
        int answer = numbers[length-1]*numbers[length-2];
        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {0,31,24,10,1,9};
        maxValue t = new maxValue();
        System.out.println(t.solution(numbers));
    }
}
