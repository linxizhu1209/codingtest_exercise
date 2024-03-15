
package chapter8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
    public int x,y;
    Point(int x,int y){
        this.x = x;
        this.y = y;
    }
}

public class test11 {
    // 강의참고하여 내가 짠 코드
    static int[][] board, dis;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int answer= Integer.MAX_VALUE;
    public void BFS(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));
        while(!q.isEmpty()){
            Point p = q.poll();
            x= p.x; y=p.y;
            if(x==7&&y==7){
                answer = Math.min(answer,dis[x][y]);
            }
            if(dis[x][y]>answer) return;
            for(int k=0;k<4;k++){
                   int nx=x+dx[k];
                   int ny=y+dy[k];
                   if(nx>=1 && nx<=7 && ny>=1 && ny<=7 && board[nx][ny]==0){
                       board[nx][ny]=1;
                       q.offer(new Point(nx,ny));
                       dis[nx][ny]=dis[x][y]+1;
                   }
           }
        }
       }

    public static void main(String[] args){
        test11 T = new test11();
        Scanner in = new Scanner(System.in);
        board=new int[8][8];
        for(int i=1;i<8;i++){
            for(int j=1;j<8;j++) {
                board[i][j]=in.nextInt();
            }
        }
        dis=new int[8][8];
        board[1][1]=1;
        T.BFS(1,1);
        if(dis[7][7]==0) System.out.println(-1);
        else System.out.println(answer);
    }
}
