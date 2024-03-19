package chapter9;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture>{
    public int money;
    public int time;
    Lecture(int money, int time){
        this.money=money;
        this.time=time;
    }
    @Override
    public int compareTo(Lecture ob){
        return ob.time-this.time;
    }
}

public class test4 {

    static int n, max = Integer.MIN_VALUE;
    public int solution(ArrayList<Lecture> arr){
        int answer =0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder()); //큰 값을 우선순위로 하는 큐로 만들어줌
        Collections.sort(arr);
        int j=0;
        for(int i=max;i>=1;i--){
            for( ; j<n;j++){
                if(arr.get(j).time<i) break;
                pQ.offer(arr.get(j).money);
            }
            if(!pQ.isEmpty()) answer+=pQ.poll(); // 가장 큰 값을 poll해준다. 가장 큰 값부터 정렬되어있기에.
        }
        return answer;
    }

    public static void main(String[] args){
        test4 T = new test4();
        Scanner in = new Scanner(System.in);
        n= in.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            int m=in.nextInt();
            int d=in.nextInt();
            arr.add(new Lecture(m,d));
            if(d>max) max = d;
        }
        System.out.println(T.solution(arr));
    }


}
