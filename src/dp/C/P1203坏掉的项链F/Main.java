package dp.C.P1203坏掉的项链F;

import java.util.ArrayList;
import java.util.Scanner;
//https://www.bilibili.com/video/BV1JA411H7eN/?spm_id_from=333.337.search-card.all.click&vd_source=0ab45cb0697be9cde13413384592f9a9
//上一次用dp写的实在过于屎山，而且测试只得了60分，实在改不动了，这次换个思路
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int count = scanner.nextInt();
        String s=new String();
        s=scanner.next();
        s=s+s;
        int i=0;
        int left=0,right=0;
        for(;i<count;i++)
            if(s.charAt(i)!='w')
                break;
        left=i;
        right=i;
        for(;i<count;i++){
            if(s.charAt(left)==s.charAt(right)||s.charAt(right)=='w')
                right++;
            else {
                i=right;
                left=right;
                right++;
                break;
            }
        }
        int windex=left;
        ArrayList<Integer> co=new ArrayList<>();
        while (true){
            while(s.charAt(left)==s.charAt(right)||s.charAt(right)=='w'&&right<i+count){
                if(s.charAt(right)!='w')
                    windex=right;
                right++;
            }
            if(right==i+count){
                co.add(right-left);
                break;
            }
            else {
                co.add(right-left);
                left=windex+1;
                right++;
                windex++;
            }
        }
        for(Integer it:co){
            System.out.println(it);
        }
    }
}
