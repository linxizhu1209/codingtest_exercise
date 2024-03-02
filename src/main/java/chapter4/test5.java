package chapter4;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class test5 {
    // 강의 참고 코드
    public int solution(int n1,int n2, int[] arr){
        int answer = -1;
        TreeSet<Integer> Tset = new TreeSet<>(Comparator.reverseOrder());
        // TreeSet은 정렬을 해줌. 기본적으로 오름차순 정렬이지만, reverseOrder해주면 내림차순 정렬


        for(int i=0;i<n1;i++){
            for(int j=i+1;j<n1;j++){
                for(int k=j+1;k<n1;k++){
                    Tset.add(arr[i]+arr[j]+arr[k]);
                }
            }
        }
        int cnt=0;
        for(int x: Tset){
            cnt++;
            if(cnt==n2){
                return x;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        test5 T = new test5();
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        int[] arr = new int[num1];
        for(int i=0;i<num1;i++){
            arr[i]=in.nextInt();
        }
        System.out.print(T.solution(num1,num2,arr));
        }
}

