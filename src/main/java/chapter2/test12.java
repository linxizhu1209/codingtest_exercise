package chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test12 {
    // 강의 참고한 코드
    public int solution(int m, int n, int[][] arr){
        int answer = 0;
        for(int i=1;i<=n;i++){ // 학생1
            for(int j=1;j<=n;j++){// 학생2
                int count=0;
                 for(int k=0;k<m;k++){ // 테스트 번호
                     int pi=0;
                     int pj=0;
                     for(int s=0;s<n;s++) { // 등수
                        if(arr[k][s]==i)
                        {
                            pi = s;
                        }  // k번째테스트의 s등이 i라면 pi(i의 등수)= s
                        else if(arr[k][s]==j){
                            pj = s;
                        } // k번째 테스트의 s등이 j라면 pj(j의 등수) = s
                         }
                     if(pi<pj) count++; // i의 등수가 j보다 높다면 ++
                 }
                 if(count==m) answer++;
            }
        }
        return answer;
    }

    // 내가 설계한 코드
//    public int solution(int m, int n, int[][] arr){
//        List<Integer> menti = new ArrayList<>();
//        List<Integer> mento = new ArrayList<>();
//        for(int i=1;i<=m;i++){
//            menti.add(arr[m][4]);
//            mento.add(arr[m][1]);
//        }
//        for(int i=1;i<=m;i++){
//            for(int j=1;j<=n;j++){
//                for(int k=0;k<mento.size();k++){
//                    for(int o=0;o<menti.size();o++){
//
//                    }
//                }
//                if(menti.indexOf())
//
//            }
//
//        }

//        return answer;
//    }

    public static void main(String[] args) {
        test12 T = new test12();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        // 강의 참고 코드
        int[][] arr = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=in.nextInt();
            }
        }
        System.out.println(T.solution(m,n,arr));

    }
}

