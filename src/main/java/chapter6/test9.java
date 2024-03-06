package chapter6;


import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class test9 {
    public int count(int[] arr, int capacity){
        int cnt = 1;
        int sum = 0;
        for(int x : arr){
            if(sum+x>capacity){
                cnt++;
                sum=x;
            }
            else sum+=x;
        }
        return cnt;
    }
    public int solution(int n, int m, int[] arr) {
        int answer=0;

        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        while(lt<=rt) {
            int sum=0;
            int mid = (lt + rt) / 2;
            // 강의 참고한 코드
            if (count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else lt = mid + 1;
        }
        return answer;
//            int count = 1;
//            for(int i=0;i<n;i++){
//                sum+=arr[i];
//                if(sum>mid){
//                    count++;
//                    sum=arr[i];
//                }
//            }
//            if(count>m) lt = mid+1;
//            else if(count<=m) {
//                answer = mid;
//                rt = mid-1;
//            }
////            else if(count==m) {
////                answer = mid;
////                rt= mid-1;
////            }
//        }
//        return answer;
    }

    public static void main(String[] args) {
        test9 T = new test9();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.print(T.solution(n,m,arr));
    }
}

