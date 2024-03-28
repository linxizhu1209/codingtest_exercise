package backjoon.과제;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Diffremaining {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<Integer> remaining = new HashSet<>();
        for(int i=0;i<10;i++){
            remaining.add(Integer.parseInt(bf.readLine())%42);
        }
        bw.write(remaining.size()+"\n");
        bw.close();

    }
}
