import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static public class isFile {
        String name;
        int isFolder; //folder면 1, 파일이면 0

        public isFile(String name, int isFolder) {
            this.name = name;
            this.isFolder = isFolder;
        }
    }
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        StringTokenizer token = new StringTokenizer(in.nextLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int s = N+M;
        List<String> list = new ArrayList<>();
        Map<String,List<isFile>> map = new HashMap<>();
        for(int i=0;i<s;i++){
            token = new StringTokenizer(in.nextLine());
            /**
             * 첫번째 토큰, 상위 폴더의 이름 P
             * 두번째 토큰, 폴더 또는 파일 이름 F
             * 세번째 토큰, 폴더 여부 C (폴더면 1, 파일이면 0)
             * 문제는 쿼리 경로가 주어지면, 그 경로 아래에 있는 파일 종류의 개수와 파일의 종류와 파일 총 개수 (파일의 종류같은 경우에는 File1이 A폴더에도 있고 B폴더에도 있을 수 있음)
             */
            String p = token.nextToken();
            String f = token.nextToken();
            int c = Integer.parseInt(token.nextToken());

            List<isFile> fileList = map.getOrDefault(p,new ArrayList<>());
            fileList.add(new isFile(f,c));
            map.put(p,fileList);
            // 맵 키값을 상위 폴더명, 맵 value를 리스트로 하고, list.add("FolderA","FolderB", "File1") 이런식으로 하고
            // 쿼리를 가져올때에는 "/"를 기준으로 마지막 단어만 가져오고 그 단어와 일치하는 key를 map에서 찾고, 걔 안에 있는 list 하나씩 돌면서 만약 file이면 count(총개수)++
            // 중복불가 set도 하나 만들어서, 파일 set에 하나씩 넣고, 마지막에 그 개수 (종류 개수) 출력
            // 만약 폴더라면 그 폴더도 똑같이 돌아야함.
            // 근데 파일이름과 폴더이름이 file~ folder~ 꼭 이런건 아니니까 구분할 수있는 무언가 있어야할듯
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int query = Integer.parseInt(in.nextLine());

        for(int i=0;i<query;i++){
            int count = 0;  // 파일 총개수
            int kindCount = 0; // 파일 종류 개수
            Set<String> fileName = new HashSet<>(); // 파일 종류 구분 위함
            String q = in.nextLine();
            String[] str= q.split("/");
            String word = str[str.length-1];

            List<isFile> strList = map.get(word);

            Queue<isFile> queue = new LinkedList<>();
            if(strList!=null) {
                for (isFile ff : strList) {
                    queue.offer(ff);
                }
            }
            while(!queue.isEmpty()){
                isFile ff = queue.poll();
                String fname = ff.name;
                int isFolder = ff.isFolder;
                if(isFolder == 1){
                    strList = map.get(fname);
                    if(strList != null) {
                        for (isFile ff2 : strList) {
                            queue.offer(ff2);
                        }
                    }
                } else{
                    count++;
                    fileName.add(fname);
                }
            }
            kindCount = fileName.size();
            bw.write(kindCount+" "+count+"\n");
        }
        /**
         * 1. 첫번째줄 폴더 개수 N, 파일 개수 M
         */
        bw.close();
    }
}