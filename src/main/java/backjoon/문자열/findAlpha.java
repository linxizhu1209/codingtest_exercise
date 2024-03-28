package backjoon.문자열;

import java.io.*;

public class findAlpha {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        for(int i=97;i<=122;i++){
            bw.write(str.indexOf((char)i)+" ");
        }
        bw.close();
    }
}
