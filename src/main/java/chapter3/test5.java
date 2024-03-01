package chapter3;

import java.util.Scanner;


public class test5 {
    // 강의 참고 코드
    public int solution(int num) {
        int answer = 0;
        int lt = 1;
        int sum = 0;
        for (int rt = 1; rt <= (num / 2) + 1; rt++) {
            // rt를 num/2 +1 까지만 도는 이유는 연속된 수의 합이 num과 같아야 하는 것이므로
            // 이를 충족할 수 있는 연속된 수 중 num/2+1이 젤 큰 숫자임
            sum += rt;
            if (sum == num) answer++;
            while(sum>=num){
                sum -= lt++;
                if (sum == num) {
                        answer++;
                    }

                }
            }

        return answer;
    }

    // 내가 짠 코드
//        int count = 0;
//        int p1 = 1;
//        for(int i=p1;i<num;i++){
//            int sum = 0;
//            for(int j=p1;j<num;j++){
//                sum += j;
//                if(sum==num){
//                    count++;
//                    break;
//                }
//                else if(sum>num) break;
//            }
//            p1++;
//        }
//        return count;
//    }

    public static void main(String[] args) {
        test5 T = new test5();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println(T.solution(num));
    }
}

