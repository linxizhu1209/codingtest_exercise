package chapter2;

import java.util.*;

public class test8 {
    // 강의 참고 코드
    private int solution(int n,int[][] arr){
        int answer = Integer.MIN_VALUE;
        int sum1,sum2;
        for(int i=0;i<n;i++){
            sum1=sum2=0;
            for(int j=0;j<n;j++){
                sum1+=arr[i][j];
                sum2+=arr[j][i];
            }
            answer=Math.max(answer,sum1);
            answer=Math.max(answer,sum2);
        }
        sum1=sum2=0;
        for(int i=0;i<n;i++){
            sum1+=arr[i][i];
            sum2+=arr[i][n-i-1];
            }
        answer=Math.max(answer,sum1);
        answer=Math.max(answer,sum2);
        return answer;
    }



// 내가 푼 코드
//    public int solution(int num,int[][] arr) {
//        List<Integer> sumList = new ArrayList<>();
//
//        int answer = 0;
//        int sum3=0; //대각선의 합
//        int sum4=0;
//        for(int i=0;i<num;i++){
//            int sum1=0; //행의합
//            int sum2=0; //열의합
//
//            for(int j=0;j<num;j++){
//                sum1 += arr[i][j];
//                sum2 += arr[j][i];
//            }
//            sumList.add(sum1);
//            sumList.add(sum2);
//            sum3 = arr[i][i];
//            sum4 = arr[num-i-1][num-i-1];
//        }
//        sumList.add(sum3);
//        sumList.add(sum4);
//        sumList.sort(Comparator.reverseOrder());
//        answer = sumList.get(0);
//        return answer;
//    }

    public static void main(String[] args) {
        test8 T = new test8();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[][] arr = new int[num][num];
        for(int i=0;i<num;i++) {
            for(int j=0;j<num;j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(T.solution(num, arr));

    }
}

