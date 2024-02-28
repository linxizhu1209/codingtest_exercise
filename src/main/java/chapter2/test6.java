package chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test6 {
    // 강의 참고한 코드

    public boolean isPrime(int num){
        if(num==1) return false;
        for(int i=2; i<num; i++){
            if(num%i==0) return false;
        }
        return true;
    }

    public List<Integer> solution(int n,int[] arr) {
        List<Integer> numlist = new ArrayList<>();
        for(int i=0;i<n;i++){
            int tmp = arr[i];
            int res = 0;
            while(tmp>0){
                int t = tmp%10;
                res=res*10+t;
                tmp=tmp/10;
            }
            if(isPrime(res)) numlist.add(res);
        }
        return numlist;
    }

    public static void main(String[] args) {
        test6 T = new test6();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];
        for(int i=0;i<num;i++) {
            arr[i] = in.nextInt();
        }
        List<Integer> answer = T.solution(num,arr);
        for(int x:answer) {
            System.out.print(x + " ");
        }
    }
}

