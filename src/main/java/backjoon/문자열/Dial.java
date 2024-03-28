package backjoon.문자열;

import java.io.*;

public class Dial {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = new String[10];

        arr[2] = "ABC"; arr[3] = "DEF"; arr[4]="GHI";
        arr[5] = "JKL"; arr[6] = "MNO"; arr[7] = "PQRS";
        arr[8] ="TUV"; arr[9] = "WXYZ";
        String str = bf.readLine();
        int answer = 0;
        for(int j=0;j<str.length();j++){
            for(int i=2;i<10;i++){
                if(arr[i].contains((str.charAt(j)+""))){
                    answer += i-1+2;
                }
            }
        }
        bw.write(answer+"\n");
        bw.close();
    }
}
