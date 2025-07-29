
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String[][] arr;
    static int n;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new String[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
               char x = str.charAt(j);
               arr[i][j] = x+"";
            }
        }

        // 열 기준 변경
        for(int i = 0; i < n; i++){
            for(int j=1;j<n;j++){
                String temp = arr[i][j-1];
                arr[i][j-1] = arr[i][j];
                arr[i][j] = temp;
                countCandy();
                arr[i][j] = arr[i][j-1];
                arr[i][j-1] = temp;
            }
        }

        // 행 기준 변경
        for(int i = 0; i < n; i++){
            for(int j=1;j<n;j++){
                String temp = arr[j-1][i];
                arr[j-1][i] = arr[j][i];
                arr[j][i] = temp;
                countCandy();
                arr[j][i] = arr[j-1][i];
                arr[j-1][i] = temp;
            }
        }
        System.out.println(max);
    }

    static private void countCandy(){
        // 열 기준 카운트
        for(int i=0;i<n;i++){
            int count = 1;
            for(int j=1;j<n;j++){
                if(arr[i][j-1].equals(arr[i][j])){
                    count++;
                    max = Math.max(max,count);
                } else count = 1;
            }
        }

        // 행 기준 카운트
        for(int i=0;i<n;i++){
            int count = 1;
            for(int j=1;j<n;j++){
                if(arr[j-1][i].equals(arr[j][i])){
                    count++;
                    max = Math.max(max,count);
                } else count = 1;
            }
        }

    }
 }
