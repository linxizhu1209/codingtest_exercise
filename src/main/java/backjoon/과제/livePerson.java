package backjoon.과제;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class livePerson {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int p = Integer.parseInt(bf.readLine());
        StringTokenizer token;
        Set<String> set = new HashSet<>();
        for(int i=0;i<p;i++){
            token = new StringTokenizer(bf.readLine());
            String name = token.nextToken();
            if(token.nextToken().equals("enter")) set.add(name);
            else set.remove(name);
        }
        /**
         * toList() 메서드의 경우 자바 버전에 따라 지원하지 않을 수 있다함
         * 따라서, collect메서드를 사용해 리스트로 변경
         */
        List<String> list = set.stream().sorted(Comparator.reverseOrder()).collect(toList());

        for(String x:list) bw.write(x+"\n");
        bw.close();
        }
}
