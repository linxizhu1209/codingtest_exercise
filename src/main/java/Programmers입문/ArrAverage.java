package Programmers입문;

import java.util.Arrays;

public class ArrAverage {
    public double solution(int[] numbers) {
        double answer = 0;
        answer = Arrays.stream(numbers).average().orElse(0);
            return answer;

    }

    public static void main(String[] args) {
        int[] numbers = {89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};
        ArrAverage t = new ArrAverage();
        System.out.println(t.solution(numbers));
    }

}
