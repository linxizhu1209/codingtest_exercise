package backjoon.문자열;

import java.io.*;

public class whereChar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int i = Integer.parseInt(br.readLine());
        bw.write(s.charAt(i-1)+"\n");
        bw.close();
    }
}
