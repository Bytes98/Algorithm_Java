package Tencent;

import java.util.*;

public class ConnectedRelation {
    static int cnt, ans;
    static int[] v = new int[100001];
    static List<List<Integer>> a = new ArrayList<>();

    static void dfs(int x){
        int i, num;
        v[x]=1; cnt++;
        for(i=0;i<a.get(x).size();i++){
            num = a.get(x).get(i);
            if(v[num]==0) dfs(num);
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int T = Integer.parseInt(s);
        for(int i = 0;i<T; i++){
            s = scanner.nextLine();
            int n = Integer.parseInt(s);
            for(int k=1;k<=n;k++){
                v[k] = 0;
                List<Integer> temp =new ArrayList<>();
                temp.add(k);
                a.add(temp);
            }
            for(int k =1; k<=n; k++){
                s = scanner.nextLine();
                String[] tempgS = s.split(" ");
                int x = Integer.parseInt(tempgS[0]);
                int y = Integer.parseInt(tempgS[1]);
                a.get(x).add(y);
                a.get(y).add(x);
            }
            ans = 0;
            for (int k=1; k<=n;k++){
                cnt = 0;
                dfs(k);
                ans = Math.max(ans,cnt);
            }
            System.out.println(ans);
        }
    }
}
