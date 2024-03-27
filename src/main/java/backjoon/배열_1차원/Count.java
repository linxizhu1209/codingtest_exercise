package backjoon.배열_1차원;


import java.util.Scanner;

public class Count {
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int count = 0;
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = in.nextInt();
        }
        int v = in.nextInt();
        for(int x:arr){
            if(x==v) count++;
        }
        System.out.println(count);
    }
    }
