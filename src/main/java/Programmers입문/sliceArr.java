package Programmers입문;

import java.util.Arrays;

public class sliceArr {
    public int[] solution(int[] numbers, int n1, int n2){
        int[] answer = new int[n2-n1+1];
        for(int i=n1;i<=n2;i++){
            answer[i-n1] = numbers[i];
        }
        return answer;

        /**
         *  다른 사람의 코드를 보고 배운 것
         */

//        int[] answer = Arrays.copyOfRange(numbers,n1,n2+1);
//        return answer;
    }

    public static void main(String[] args) {
        sliceArr t = new sliceArr();
        int[] numbers = {1,3,5};
        int num1 = 1;
        int num2 = 2;
        System.out.println(Arrays.toString(t.solution(numbers,num1,num2)));
    }
}
