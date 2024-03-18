package dp.C.P1049装箱问题R;

import java.util.*;


//https://www.luogu.com.cn/problem/P1049
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int V=scanner.nextInt();
        int n=scanner.nextInt();
        ArrayList<Integer> co=new ArrayList<>();
        for(int i=0;i<n;i++){
            co.add(scanner.nextInt());
        }
        ArrayList<ArrayList<Integer>> dparr=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            ArrayList<Integer> arr=new ArrayList<>();
            for(int j=0;j<V+1;j++){
                arr.add(0);
            }
            dparr.add(arr);
        }
        for(int i=0;i<V+1;i++){
            dparr.get(0).set(i,i);
        }
        for(int i=1;i<n+1;i++){
            int additem=co.get(i-1);
            for(int j=1;j<V+1;j++){
                int past=999;
                int up=dparr.get(i-1).get(j);
                if(j-additem>=0)
                    past=dparr.get(i-1).get(j-additem);
                dparr.get(i).set(j, Math.min(past, up));
            }
        }
        System.out.println(dparr.get(n).get(V));

    }
}
