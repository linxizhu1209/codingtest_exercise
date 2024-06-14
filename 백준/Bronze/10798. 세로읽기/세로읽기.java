import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<String[]> graph = new ArrayList<>();
        int max = 0;
        for(int i=0;i<5;i++) {
            String[] str = br.readLine().split("");
            graph.add(str);
            max = Math.max(max,str.length);
        }
        for(int j=0;j<max;j++){
            for(int i=0;i<5;i++){
                if(graph.get(i).length<=j) continue;
                bw.write(graph.get(i)[j]);
            }
        }
        bw.close();
    }
}
