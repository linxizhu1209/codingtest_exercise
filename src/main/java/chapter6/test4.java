package chapter6;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test4 {
    public int[] solution(int n,int m, int[] arr){
       int[] cache = new int[n];
       for(int x:arr){
           int pos = -1;
           for(int i=0;i<n;i++) if(x==cache[i]) pos=i;
           if(pos==-1){
               for(int i=n-1;i>=1;i--){
                   cache[i]=cache[i-1];
               }
               cache[0]=x;
           }
           else{
               for(int i=pos;i>=1;i--){
                   cache[i]=cache[i-1];
               }
               cache[0]=x;
           }
       }

return cache;
    }



    // 내가 짠 코드
//    public int[] solution(int n, int m, int[] arr){
//        Queue<Integer> q = new LinkedList<>();
//        for(int i=0;i<m;i++){
//            if(q.contains(arr[i])){
//                int s = q.size();
//                for(int j=0;j<s;j++){
//                    if(q.peek()!=arr[i]) {
//                        q.offer(q.poll());
//                    }
//                    else q.poll();
//                }
//                q.offer(arr[i]);
//            }
//            else if(q.size()==n&&!q.contains(arr[i])){
//                q.poll();
//                q.offer(arr[i]);
//            }
//            else q.offer(arr[i]);
//            }
//
//        return q.stream().mapToInt(i->i).toArray();
//    }


    public static void main(String[] args) {
        test4 T = new test4();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = in.nextInt();
        }
        int[] result = T.solution(n,m,arr);
//        for (int i=result.length-1;i>=0;i--){
//            System.out.print(result[i] + " ");
//        }
        for (int x:result){
            System.out.print(x + " ");
        }
    }
}

