package dp.C.P1060开心的金明R;
import java.util.*;

public class Main {
    static class item{
        item(int v,int s){
            this.value=v;
            this.severity=s;
        }
        int value;
        int severity;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        ArrayList<item> itco=new ArrayList<>();
        int V=scanner.nextInt();
        int n=scanner.nextInt();
        for(int i=0;i<n;i++){
            item it=new item(scanner.nextInt(),scanner.nextInt());
            itco.add(it);
        }
        for(int i=0;i<n+1;i++){
            ArrayList<Integer> ar=new ArrayList<>();
            for(int j=0;j<V+1;j++){
                ar.add(0);
            }
            arr.add(ar);
        }
        for(int i=1;i<n+1;i++){
            item item=itco.get(i-1);
            for(int j=1;j<V+1;j++){
                if(j-item.value<0){
                    arr.get(i).set(j,arr.get(i-1).get(j));
                    continue;
                }
                arr.get(i).set(j,Math.max(
                        arr.get(i-1).get(
                                j-item.value
                        )+item.value*item.severity
                        ,arr.get(i-1).get(j)));
            }
        }
        System.out.println(arr.get(n).get(V));
    }
}
