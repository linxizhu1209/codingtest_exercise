
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
        Map<String,List<isFile>> map = new HashMap<>();
        for(int i=0;i<s;i++){
            token = new StringTokenizer(in.nextLine());
            String p = token.nextToken();
            String f = token.nextToken();
            int c = Integer.parseInt(token.nextToken());

            List<isFile> fileList = map.getOrDefault(p,new ArrayList<>());
            fileList.add(new isFile(f,c));
            map.put(p,fileList);
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
        bw.close();
    }
}