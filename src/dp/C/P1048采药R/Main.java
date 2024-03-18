package dp.C.P1048采药R;

import java.util.ArrayList;
import java.util.Scanner;
//题目类型：01背包问题
//题目地址：https://www.luogu.com.cn/problem/P1048
//教学视频：https://www.bilibili.com/video/BV1pY4y1J7na/?spm_id_from=333.337.search-card.all.click&vd_source=0ab45cb0697be9cde13413384592f9a9
public class Main {
    static class item{
        int value;
        int time;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int T=scanner.nextInt();
        int M=scanner.nextInt();
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        for(int i=0;i<=M;i++){
            ArrayList<Integer> a=new ArrayList<>();
            for(int j=0;j<=T;j++){
                a.add(0);
            }
            arr.add(a);
        }
        ArrayList<item> items=new ArrayList<>();
        for(int i=0;i<M;i++){
            item it=new item();
            it.time=scanner.nextInt();
            it.value=scanner.nextInt();
            items.add(it);
        }
        for (int i=1;i<=M;i++)
            for(int j=1;j<=T;j++){
                if(j<items.get(i-1).time)
                    arr.get(i).set(j,arr.get(i-1).get(j));
                else
                    arr.get(i).set(j
                            ,arr.get(i-1).get(j-items.get(i-1).time)+items.get(i-1).value
                            >arr.get(i-1).get(j)
                            ?arr.get(i-1).get(j-items.get(i-1).time)+items.get(i-1).value
                            :arr.get(i-1).get(j)
                    );
            }
        System.out.println(arr.get(M).get(T));
    }
}
