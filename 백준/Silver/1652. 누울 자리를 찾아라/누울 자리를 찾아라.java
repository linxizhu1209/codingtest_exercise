import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int width = 0;
        int height = 0;
        int blank = 0;
        TreeMap<Integer,Integer> blankmap = new TreeMap<>();
        for(int i=0;i<n;i++){
            String[] str = bf.readLine().split("");
            blank = 0;
            for(int j=0;j<n;j++){
                if(str[j].equals(".")){
                    blank++;
                    blankmap.put(j,blankmap.getOrDefault(j,0)+1);
                    if(blank==2){
                        width++;
                    }
                    if(blankmap.containsKey(j)&&blankmap.get(j)==2){
                        height++;
                    }
                }
                else{
                    blank = 0;
                    blankmap.put(j,0);
                }
            }
        }
        System.out.println(width);
        System.out.println(height);
    }
}
