package backjoon.과제;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class differentString {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(bf.readLine());
        Set<String> strset = new HashSet<>();
        int length = sb.length();
        for(int i=0;i<length;i++){
            for(int j=i+1;j<=length;j++){
                strset.add(sb.substring(i,j));
            }
        }
        bw.write(strset.size()+"\n");
        bw.close();
    }
}
