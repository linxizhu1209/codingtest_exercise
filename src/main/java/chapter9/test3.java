package chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//강의 참고하여 내가 짠 코드
class Time implements Comparable<Time> {
    public int x;
    public String y;

    Time(int x, String y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Time o) {
        if (this.x == o.x) {
            return this.y.compareTo(o.y); // char로 했을때 '-'로 해결가능
        } else {
            return this.x - o.x; //오름차순 정렬
        }
    }
}
public class test3 {
    public int solution(ArrayList<Time> arr,int n) {
        int answer = 0;
        int cnt = 0;
        Collections.sort(arr);
        for(Time x:arr) {
            if (x.y.equals("s")) {
                cnt++;
                answer = Math.max(answer,cnt);
            } else cnt--;
        }
            return answer;
    }

    public static void main(String[] args) {
        test3 T = new test3();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Time> p = new ArrayList<>();
        for(int i=0;i<n;i++){
            int x=in.nextInt();
            int y=in.nextInt();
            p.add(new Time(x,"s"));
            p.add(new Time(y,"e"));
        }
        System.out.println(T.solution(p,n));
    }
}
