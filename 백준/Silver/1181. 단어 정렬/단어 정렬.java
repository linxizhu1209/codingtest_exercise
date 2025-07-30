
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()!=o2.length()){
                    return o1.length()-o2.length();
                }
                return o1.compareTo(o2);
            }
        });
        for(int i=0;i<n;i++){
            String str= br.readLine();
            pq.add(str);
        }
        String str = "";
        for(int i=0;i<n;i++){
            String poll = pq.poll();
            if(!str.equals(poll)) {
                str = poll;
                System.out.println(poll);
            }
        }
    }
 }
