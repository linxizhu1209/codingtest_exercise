
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

public class test12 {
    // 강의참고하여 내가 짠 코드
    static int[][] board, dis;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n,m;
    static Queue<Point> q = new LinkedList<>();
    public void BFS(){
        while(!q.isEmpty()){
            Point p = q.poll();
            int x= p.x;
            int y=p.y;
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny]==0){
                    board[nx][ny]=1;
                    q.offer(new Point(nx,ny));
                    dis[nx][ny]=dis[x][y]+1;
            }
            }
        }
        }

    public static void main(String[] args){
        test12 T = new test12();
        Scanner in = new Scanner(System.in);
        m=in.nextInt();
        n=in.nextInt();
        board=new int[n][m];
        dis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                board[i][j]=in.nextInt();
                if(board[i][j]==1) q.offer(new Point(i,j));
            }
        }
        T.BFS();
        boolean flag = true;
        int answer = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0; j<m;j++){
                if(board[i][j]==0) flag=false;
            }
        }
        if(flag){
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    answer=Math.max(answer,dis[i][j]);
                }
            }
            System.out.println(answer);
        }
        else System.out.println(-1);
    }
}