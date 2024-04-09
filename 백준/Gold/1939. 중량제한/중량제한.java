import java.io.*;
import java.util.ArrayList;

class KG implements Comparable<KG>{
    int il;
    int kg;

    public KG(int il, int kg) {
        this.il = il;
        this.kg = kg;
    }

    @Override
    public int compareTo(KG o) {
        if(this.il==o.il) return o.kg-this.kg;
        return this.il-o.il;
    }
}
public class Main {
    static ArrayList<ArrayList<KG>> list;
    static int n,m,x,y,answer;
    static int max = Integer.MIN_VALUE;
    static int[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] num = br.readLine().split(" ");
        n = Integer.parseInt(num[0]);
        m = Integer.parseInt(num[1]);
        list = new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        int maxWeight = 0;
        int minWeight = 0;
        for(int i=0;i<m;i++){
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);
            list.get(a).add(new KG(b,c));
            list.get(b).add(new KG(a,c));
            maxWeight = Math.max(maxWeight,c);
        }
        String[] str = br.readLine().split(" ");
        x = Integer.parseInt(str[0]);
        y = Integer.parseInt(str[1]);
        Main t = new Main();
        while(minWeight<=maxWeight){
            int mid = (maxWeight+minWeight)/2;
            check = new int[n+1];
            answer = -1;
            t.dfs(x,y,mid);
            if(answer==-1){
                // dfs에 mid를 넘겨줬을때 그 answer값이 리턴되지 않았다는 것(-1이 바뀌지않았다는것)은 그 중량을 갖고 목적지까지 갈 수 없다는 뜻이므로 중량을 더 줄여주는 작업을 한다
                maxWeight = mid-1;
            }
            else{
                // -1이 아니라는 것은 mid(중량)을 갖고 목적지까지 갈 수 있다는 것이므로 중량을 더 높여서 목적지까지 갈 수 있는지 확인해본다.
                minWeight = mid+1;
            }
        }
        bw.write(maxWeight+"\n");
        bw.close();
    }
    public void dfs(int x,int y, int mid){
        if(x==y){
            answer = x; // -1 값을 바꿔주기위한 것이고 답은 아님
        }
        else {
            check[x] = 1;
            ArrayList<KG> nowIsland = list.get(x);
            for (KG k : nowIsland) {
                if (check[k.il] == 0&&mid<=k.kg) {
                    dfs(k.il, y,mid);
                }
            }
        }
    }
}
