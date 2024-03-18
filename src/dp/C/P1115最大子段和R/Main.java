package dp.C.P1115最大子段和R;

import java.util.ArrayList;
import java.util.Scanner;

//这里进行修改
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        ArrayList<Integer> co=new ArrayList<>();
        ArrayList<Integer> dp=new ArrayList<>();
        for(int i=0;i<n;i++){
            co.add(scanner.nextInt());
        }
        int max=-999;
        for(int i=0;i<n+1;i++){
            dp.add(0);
        }
        for(int i=1;i<n+1;i++){
            if(dp.get(i-1)>0)
                dp.set(i,dp.get(i-1)+co.get(i-1));
            else dp.set(i,co.get(i-1));
            if(dp.get(i)>max)
                max= dp.get(i);
        }
        System.out.println(max);
    }
}
