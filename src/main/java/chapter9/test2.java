package chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Room implements Comparable<Room>{
    public int x,y;
    Room(int x,int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Room o){
        if(this.y==o.y){
            return this.x-o.x;
        }
        else return this.y-o.y; //오름차순 정렬
    }
}
public class test2 {
    public int solution(ArrayList<Room> arr,int n) {
        int answer = Integer.MIN_VALUE;
        int cnt = 0;
        Collections.sort(arr);
        int max = Integer.MIN_VALUE;
        for (Room ob : arr) {
            if (ob.x >= max) {
                max = ob.y;
                cnt++;
            }
        }
        return cnt;
    }
//
    public static void main(String[] args) {
        test2 T = new test2();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Room> p = new ArrayList<>();
        for(int i=0;i<n;i++){
            int x=in.nextInt();
            int y=in.nextInt();
            p.add(new Room(x,y));
        }
        System.out.println(T.solution(p,n));
    }
}
