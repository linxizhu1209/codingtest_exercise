
package chapter8;

import java.util.Scanner;

public class test10 {
    // 강의참고하여 내가 짠 코드
    static int[][] board;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int answer = 0;
    public void DFS(int x, int y){
       if(x==7&&y==7){
           answer++;
       }
       else{
           for(int k=0;k<4;k++){
               int nx=x+dx[k];
               int ny=y+dy[k];
               if(nx>=1 && nx<=7 && ny>=1 && ny<=7 && board[nx][ny]==0){
                   board[nx][ny]=1;
                   DFS(nx,ny);
                   board[nx][ny]=0;
               }
           }
       }
    }

    public static void main(String[] args){
        test10 T = new test10();
        Scanner in = new Scanner(System.in);
        board=new int[8][8];
        for(int i=1;i<8;i++){
            for(int j=1;j<8;j++) {
                board[i][j]=in.nextInt();
            }
        }

        board[1][1]=1;
        T.DFS(1,1);
        System.out.println(answer);
    }
}
