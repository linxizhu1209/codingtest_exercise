import java.io.*;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) throws IOException {

        /**
         * 1. 자주나오는 단어일 수록 앞에
         * 2. 단어길이가 길수록 앞에
         * 3. 알파벳 사전 순으로 앞에있는 단어일수록 앞에
         * 4. 주어지는 단어의 개수 N과 단어길이 M이 주어지는데, M길이 이상의 단어만 외운다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        Map<String, Integer> wordMap = new HashMap<>();
        for(int i=0;i<n;i++){
            String word = br.readLine();
            if(word.length() >= m){
                wordMap.put(word,wordMap.getOrDefault(word,0)+1);
            }
        }
        List<String> wordList = new ArrayList<>(wordMap.keySet());

        Collections.sort(wordList, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                if(wordMap.get(o1)!=wordMap.get(o2)){
                    return wordMap.get(o2)-wordMap.get(o1);
                }
                if(o1.length()!=o2.length()){
                    return o2.length()-o1.length();
                }
                return o1.compareTo(o2);
            }
        });
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(String word : wordList){
            bw.write(word +"\n");
        }
        bw.flush();
        bw.close();
    }
}