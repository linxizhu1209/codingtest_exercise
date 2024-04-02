import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
    static int[][] arr;
    static int[] dx;
    static int[] dy;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        Main t = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[20][20];
        dx = new int[]{0,-1,0,1,-1,-1,1,1}; // 왼위오아, 왼위,오위,오아,왼아
        dy = new int[]{-1,0,1,0,-1,1,1,-1};
        int start = 0;
        int[] startXY = new int[2];
        for(int i=1;i<=19;i++){
            String[] str = br.readLine().split(" ");
            for(int j=1;j<=19;j++){
                int n = Integer.parseInt(str[j-1]);
                arr[i][j] = n;
                if(start==0&&n!=0){
                    startXY[0] = i;
                    startXY[1] = j;
                    start = 1;
                }
            }
        }
        int n = t.solution(startXY);
        System.out.println(n);
        if(n!=0) {
            System.out.println((answer[0]) + " " + (answer[1]));
        }
    }
    public int solution(int[] startXY) {

        for (int i = startXY[0]; i <= 19; i++) {
            for (int j = startXY[1]; j <= 19; j++) {
                int blackCount = 0;
                int whitecount = 0;
                if (arr[i][j] == 0) continue;
                if (arr[i][j] == 1) {
                    for (int d = 0; d < 8; d++) {
                        int minY = Integer.MAX_VALUE;
                        int minX = 0;
                        int x= i;
                        int y= j;
                        blackCount = 1;
                        for (int c = 1; c <= 5; c++) {
                            if(minY>y){
                                minY = y;
                                minX = x;
                            }
                            if (x+dx[d]>0&&y+dy[d]>0&&x+dx[d]<20&&y+dy[d]<20&&arr[x+dx[d]][y+dy[d]] == 1) {
                                blackCount++;
                                x= x+dx[d];
                                y= y+dy[d];
                            }
                            else break;
                        }
                        if (blackCount == 5 && (i-dx[d]==0||j-dy[d]==0||i-dx[d]==20||j-dy[d]==20||arr[i-dx[d]][j-dy[d]]!=1)) {
                            answer = new int[]{minX,minY};
                            return 1;
                        }
                    }
                } else if (arr[i][j] == 2) {

                    for (int d = 0; d < 8; d++) {
                        whitecount = 1;
                        int x = i;
                        int y = j;
                        int minY = Integer.MAX_VALUE;
                        int minX = 0;
                        for (int c = 1; c <= 5; c++) {
                            if(minY>y){
                                minY = y;
                                minX = x;
                            }
                            if (x+dx[d]>0&&y+dy[d]>0&&x+dx[d]<20&&y+dy[d]<20&&arr[x+dx[d]][y+dy[d]] == 2) {
                                whitecount++;
                                x= x+dx[d];
                                y= y+dy[d];
                            }
                            else break;
                        }
                        if(whitecount == 5 && (i-dx[d]==0||j-dy[d]==0||i-dx[d]==20||j-dy[d]==20||arr[i-dx[d]][j-dy[d]]!=2)) {
                            answer = new int[]{minX,minY};
                            return 2;
                        }
                    }
                }
            }
        }
        return 0;
    }

}
