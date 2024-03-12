package 公用方法包.Test;

import 公用方法包.DP公用方法.DPPo;

public class Dppo extends DPPo {
    int value;
    int dp;
    Dppo(int v,int d){
        value=v;
        dp=d;
    }
    @Override
    public String toS() {
        return "value:"+value+",dp:"+dp;
    }

}
