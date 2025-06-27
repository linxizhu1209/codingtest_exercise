import java.util.*;

public class Main {

    /**
     * 1. 키워드 n개
     * 2. 새 글 작성할때마다 최대 10개의 키워드에 대해 작성
     * 3. 블로그 작성 후 키워드는 사라짐
     * 4. 블로그 글 개수와 총 키워드 수가 주어질때,  현재 메모장에 남아있는 키워드의 개수는?
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(in.nextLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> keyword = new HashSet<>();
        for(int i=0;i<n;i++){
            keyword.add(in.nextLine());
        }

        for(int i=0;i<m;i++){
            String word = in.nextLine();
            String[] words = word.split(",");
            for(String word2 : words){
                keyword.remove(word2);
            }
            System.out.println(keyword.size());
        }
    }


}