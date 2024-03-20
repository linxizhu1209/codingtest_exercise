package chapter10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
class Point implements Comparable<Point>{
    public int s;
    public int h;
    public int w;

    public Point(int s, int h, int w) {
        this.s = s;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Point o) {
        return o.s-this.s;
    }
}

public class test4 {
    static int[] dy;
    public int solution(ArrayList<Point> list){
        int answer=0;
        Collections.sort(list);
        dy=new int[list.size()];
        dy[0]=list.get(0).h;
        for(int i=1;i<list.size();i++){
            int max=0;
            for(int j=i-1;j>=0;j--){
                if(list.get(j).w>list.get(i).w && dy[j]>max) max=dy[j];
            }
            dy[i]=max+list.get(i).h;
            answer=Math.max(answer,dy[i]);
        }
        return answer;
    }
    public static void main(String[] args){
        test4 T = new test4();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Point> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            int s = in.nextInt();
            int h = in.nextInt();
            int w = in.nextInt();
            list.add(new Point(s,h,w));
        }
        System.out.println(T.solution(list));
    }
}



