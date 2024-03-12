package 公用方法包.DP公用方法;

import java.util.ArrayList;

public class DPboard<T extends DPPo> {
    //dp板子
    ArrayList<ArrayList<T>> dpboard=new ArrayList<>();
    private int x;
    private int y;

    //节点工厂，获得节点创建权，并对节点初始化
    PoFactory factory;
    private IterOperation<T> iterOperation;
    public void Run(IterOperation<T> iterOperation){
        this.iterOperation=iterOperation;
        iterDP(x,y);
    }
    public void Run(int x1,int y1,IterOperation<T> iterOperation){
        this.iterOperation=iterOperation;
        iterDP(Math.min(x1, x), Math.min(y1, y));
    }
    public DPboard(int x, int y, PoFactory factory){
        this.x=x;
        this.y=y;
        this.factory=factory;
        for(int i=0;i<x;i++){
            ArrayList<T> a=new ArrayList<>();
            for (int j=0;j<y;j++){
                a.add((T) factory.get());
            }
            dpboard.add(a);
        }
    }
    //指定区域遍历
    public void iterDP(int x,int y){
        for(int i=0;i<x;i++)
            for (int j=0;j<y;j++)
                iterOperation.operation(getPo(i,j),getPo(i,j-1),getPo(i-1,j),i,j);

    }
    //全区域遍历
    public T getPo(int x1,int y1){
        if(x1>=x||x1<0||y1>=y||y1<0){
            return null;
        }
        return dpboard.get(x1).get(y1);
    }
}
