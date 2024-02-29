package chapter2;

import java.util.*;
    public class test10 {
        // 강의 참고한 코드
        public int solution(int n, int[][] arr){
            int answer = 0, max=Integer.MIN_VALUE;
            for(int i=1;i<n;i++){  // 1번학생
                int cnt = 0;
                for(int j=1;j<n;j++){ // 1번학생
                    for(int k=1; k<=5;k++){ // 학년
                        if(arr[i][k]==arr[j][k]){
                            cnt++;
                            break; // i번학생과 j번학생이 1~5학년 중
                            // 한번이라도 반이 겹쳤던 경우가 있다면 break를 통해 학년을 그만돌고 다음 j번학생으로 넘어간다
                        }
                    }
                }
                if(cnt>max){
                    max=cnt;
                    answer=i;
                }
            }
            return answer;
        }

//    // 내가 푼 코드
//        public int solution(int num,int[][] arr) {
//            int[] answer = new int[num];
//            Set<Integer> student = new HashSet<>();
//            for(int i=0;i<num;i++){
//                for(int j=0;j<5;j++){
//                    for(int m=0;m<num;m++){
//                    if(arr[m][j] == arr[i][j]&&i!=m) {
//                        student.add(m);
//                    }
//                    }
//                }
//                answer[i] = student.size();
//                student.clear();
//            }
//            int max = 0;
//            int result = 0;
//            for(int i=0;i<num;i++){
//                if(answer[i]>max) {
//                    result=i;
//                    max=answer[i];}
//            }
//            return result+1;
//        }
//
        public static void main(String[] args) {
            test10 T = new test10();
            Scanner in = new Scanner(System.in);
            int num = in.nextInt();
            // 내가 푼 코드
//            int[][] arr = new int[num][5];
//            for(int i=0;i<num;i++) {
//                for(int j=0;j<5;j++) {
//                    arr[i][j] = in.nextInt();
//                }
//            }

            // 강의 참고 코드
            int[][] arr = new int[num+1][6];
            for(int i=1;i<=num;i++){
                for(int j=1;j<=5;j++){
                    arr[i][j]=in.nextInt();
                }
            }
            System.out.println(T.solution(num, arr));

        }
    }

