package backjoon.문자열;

import java.io.*;

public class ascii {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        bw.write((int) str.charAt(0) + "\n");
        bw.close();
    }
}
