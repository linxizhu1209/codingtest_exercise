import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] colorPaper;
    static int white = 0;
    static int blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        colorPaper = new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                colorPaper[i][j] = Integer.parseInt(token.nextToken());
            }
        }
        sameColor(0,0,n); // 맨 처음에는 종이의 맨위왼쪽칸부터 종이전체 탐색
        bw.write(white+"\n");
        bw.write(blue+"\n");
        bw.close();
    }
    private static void sameColor(int a,int b,int size){
        for(int i=a;i<a+size;i++){
            for(int j=b;j<b+size;j++){
                // 색종이 사이즈만큼 모두 같은 색인지 탐색해야하므로 이중 for문
                if(colorPaper[i][j]!=colorPaper[a][b]){
                    int divideSize = size/2;
                    sameColor(a,b,divideSize);
                    sameColor(a+divideSize,b,divideSize);
                    sameColor(a,b+divideSize,divideSize);
                    sameColor(a+divideSize,b+divideSize,divideSize);

                    return;
                }
            }
        }
        if(colorPaper[a][b]==1) blue++;
        else white++;
    }
}
