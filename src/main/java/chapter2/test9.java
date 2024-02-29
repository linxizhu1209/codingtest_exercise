package chapter2;

import java.util.*;

public class test9 {
    // 강의 참고 코드
    int[] dx={-1,0,1,0};
    int[] dy={0,1,0,-1};
    public int solution(int num, int[][] arr){
        int answer=0;
        for(int i=0;i<num;i++){
            for(int j=0;j<num;j++){
                boolean flag = true;
                for(int k=0;k<4;k++){
                    int nx=i+dx[k];
                    int ny=j+dy[k];
                    if(nx>=0 && nx<num && ny>=0 && ny<num && arr[nx][ny]>=arr[i][j]){
                        flag=false;
                        break;
                    }
                }
                if(flag) answer++;
            }
        }
        return answer;
    }

// 내가 푼 코드
//    public int solution(int num,int[][] arr) {
//        int count = 0;
//        int answer = 0;
//        int u = 0;
//        int d = 0;
//        int r = 0;
//        int l = 0;
//        int m = 0;
//        for(int i=1;i<num+1;i++){
//            for(int j=1;j<num+1;j++){
//                m = arr[i][j];
//                u = arr[i-1][j];
//                d = arr[i+1][j];
//                r = arr[i][j+1];
//                l = arr[i][j-1];
//            if(m>u&&m>d&&m>r&&m>l) count++;
//            }
//        }
//
//        return count;
//    }

    public static void main(String[] args) {
        test9 T = new test9();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
      // 강의 참고한 코드
        int[][] arr = new int[num][num];
        for(int i=0;i<num;i++) {
            for(int j=0;j<num;j++) {
                arr[i][j] = in.nextInt();
            }
        }
        // 내가 짠 코드
//        int[][] arr = new int[num+2][num+2];
//        for(int i=1;i<num+1;i++) {
//            for(int j=1;j<num+1;j++) {
//                arr[i][j] = in.nextInt();
//            }
//        }
        System.out.println(T.solution(num, arr));

    }
}

