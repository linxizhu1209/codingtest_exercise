package backjoon.배열_1차원;

import java.io.*;
import java.util.StringTokenizer;

public class reverseBasket {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;
        token = new StringTokenizer(bf.readLine());
        int basket = Integer.parseInt(token.nextToken());
        int count = Integer.parseInt(token.nextToken());
        int[] arr = new int[basket + 1];
        for (int i = 1; i <= basket; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < count; i++) {
            token = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(token.nextToken());
            int m = Integer.parseInt(token.nextToken());
            while (n <= m) {
                int tmp = arr[n];
                arr[n] = arr[m];
                arr[m] = tmp;
                n++;
                m--;
            }
        }
            for (int x = 1; x <= basket; x++) {
                bw.write(arr[x] + " ");
            }
            bw.close();
    }
}
            // 반례 : 10 1 과 같이 입력했을때, answer 에 10이 1과 0으로 인식되기에 안됨

            //        String answer = "";
//        for(int i=1;i<=basket;i++) answer+=i;
//        StringBuilder sb;
//        for(int i=1;i<=count;i++){
//            token = new StringTokenizer(bf.readLine());
//            int n = Integer.parseInt(token.nextToken());
//            int m = Integer.parseInt(token.nextToken());
//            String sub= answer.substring(n-1,m);
//            String reversesub= new StringBuilder(sub).reverse().toString();
//            answer = answer.replace(sub,reversesub);
//        }
//        for(char x:answer.toCharArray()){
//            bw.write(x+" ");
//        }
//        bw.close();
//    }
//}
