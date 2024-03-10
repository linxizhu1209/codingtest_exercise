package chapter7;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class test8 {
    int answer = 0;
    int[] dis = {1, -1, 5};
    int[] ch;
    Queue<Integer> q = new LinkedList<>();

    public int BFS(int s, int e) {
        int L =0;
        ch=new int[10001];
        ch[s]=1;
        q.offer(s);
        while (!q.isEmpty()){
            int len=q.size();
            for(int i=0;i<len;i++){
                int x = q.poll();
//                if(x==e) return L;
                for(int j=0; j<3;j++){
                    int nx=x+dis[j];
                    if(nx==e) return L+1;
                    if(nx>=1&&nx<=10000&&ch[nx]==0){
                        ch[nx] = 1;
                        q.offer(nx);
                    }
                }
            }
            L++;
        }
        return answer;
    }


    public static void main(String[] args) {
        test8 T = new test8();
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int e = in.nextInt();
        System.out.println(T.BFS(s,e));
    }
}


// 레벨탐색을 이용하지아낳고 내가 짠 코드
//public class test8 {
//    public int solution(int n, int m){
//        int answer = 0;
//        if(n<m) {
//            int dit = m - n;
//            int fcount = dit / 5; //앞으로 5 이동 개수
//            int c = dit % 5; // 앞으로 5씩 이동했을때 송아지까지의 거리
//            if (c == 3) answer = fcount + c;
//            else if (c > 3) answer = fcount + 1 + (5 - c);
//            else answer = fcount + c;
//        }
//        else answer = n-m;
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        test8 T = new test8();
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        System.out.print(T.solution(n,m));
//        }
//    }
//
//
