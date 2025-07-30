
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(token.nextToken());
        int b= Integer.parseInt(token.nextToken());
        int len = a-b;
        int v = Integer.parseInt(token.nextToken());
//        long sum = 0;
//        int count = 1;
//        while(sum<v){
//            sum+=a;
//            if(sum>=v) break;
//            sum-=b;
//            count++;
//        }
    if((v-b)%(a-b)!=0){
        System.out.println(((v-b)/len)+1);
    } else System.out.println((v-b)/len);
    }
 }
