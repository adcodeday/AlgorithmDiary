package dp.C.P1115最大子段和R;

import java.util.ArrayList;
import java.util.Scanner;
//使用二位dp数组，导致内存超了，还是没有找到最好的状态方程
//https://www.luogu.com.cn/problem/P1115
public class MainC {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        ArrayList<ArrayList<Integer>> dp=new ArrayList<>();
        ArrayList<Integer> co=new ArrayList<>();
        for(int i=0;i<n;i++){
            co.add(scanner.nextInt());
        }
        for(int i=0;i<n+1;i++){
            ArrayList<Integer> a=new ArrayList<>();
            for(int j=0;j<n+1;j++){
                a.add(-1);
            }
            dp.add(a);
        }
        int max=0;
        dp.get(0).set(0,0);
        for(int i=1;i<n+1;i++){
            dp.get(0).set(i,dp.get(0).get(i-1)+co.get(i-1));
            max=Math.max(dp.get(0).get(i),max);
            dp.get(i).set(i,0);
        }
        for(int i=1;i<n+1;i++){
            for(int j=i+1;j<n+1;j++){
                dp.get(i).set(j
                        ,Math.max(
                                dp.get(i-1).get(j)-co.get(i-1)
                                ,dp.get(i).get(j-1)+co.get(j-1)
                        )
                        );
                max=Math.max(dp.get(i).get(j),max);
            }
        }
        System.out.println(max);
    }
}
