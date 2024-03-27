package backjoon.반복문;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BufferedReader 사용법
 * 1. new BufferedReader(new InputStreamReader(System.in))로 선언
 * 2. readLine() 메서드 활용 -> 다만 String으로 리턴되므로 다른 타입 리턴원할 시 형변환 필요
 * 3. 예외처리 반드시해줘야함 IOException
 * 4. readLine()은 Line단위로 읽어오기에 공백단위로 가공하려면 StringTokenizer의 nextToken메서드
 * 또는 문자열.split(" ")의 방법을 사용하면 된다.
 */

/**
 * BufferedWriter 사용법
 * 1. new BufferedWriter(new OutputStreamWriter(System.out));
 * 2. write(문자열+"\n") 버퍼에 있는 값을 전부 출력한다.
 * 여기서 중요한건 자동개행기능이 없기에 개행을 해줘야할 경우 \n을 사용해야한다
 * 3. 버퍼를 잡아논 상태이기에 무조건 flush() 또는 close()를 해줘야한다.
 */
public class fastAPlusB {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token;
        int t = Integer.parseInt(bf.readLine());
        for(int i=0;i<t;i++) {
            token = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            bw.write(a+b+"\n");

        }
        bw.close();

    }


}
