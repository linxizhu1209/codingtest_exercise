package chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Point implements Comparable<Point>{
    public int x,y;
    Point(int x,int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point o){
        return o.x-this.x; //내림차순 정렬
    }
}
public class test1 {
    public int solution(ArrayList<Point> arr,int n){
        int cnt=0;
        Collections.sort(arr);
        int max = Integer.MIN_VALUE;
        for(Point ob:arr){
            if(ob.y>max){
                max=ob.y;
                cnt++;
            }
        }
        return cnt;
    }

//    // 내가 짠 코드
//    public int solution(List<Point> p, int n) {
//        int answer=0;
//        for(int i=0;i<n;i++){
//            boolean flag= true;
//            Point p2 = p.get(i);
//            for(Point l:p){
//                if(p2.x<l.x&&p2.y<l.y){
//                    flag=false;
//                    break;
//                }
//            }
//            if(flag) answer++;
//        }
//        return answer;
//    }
    public static void main(String[] args) {
        test1 T = new test1();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Point> p = new ArrayList<>();
        for(int i=0;i<n;i++){
            int x=in.nextInt();
            int y=in.nextInt();
            p.add(new Point(x,y));
        }
        System.out.println(T.solution(p,n));
    }
}
