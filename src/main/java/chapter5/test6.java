package chapter5;

import java.util.*;


public class test6 {
    // 강의 참고 코드
    public int solution(int n, int m) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>(); // queue 는 linkedList로 선언
        for(int i=1;i<=n;i++) { //
            q.offer(i);
        }
        while(q.size()!=1){
            for(int i=1;i<m;i++){
                int a= q.poll(); // poll은 꺼내고 그 값을 return 받음
                q.offer(a);
            }
            q.poll();
        }
        answer = q.peek();
        return answer;
    }


    public static void main(String[] args) {
        test6 T = new test6();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        System.out.print(T.solution(n,m));
    }
}

