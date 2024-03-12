package 公用方法包.Test;

import 公用方法包.DP公用方法.DPPo;
import 公用方法包.DP公用方法.PoFactory;

public class Dfa extends PoFactory {
    @Override
    protected Dppo get() {
        return new Dppo(0,0);
    }
}
