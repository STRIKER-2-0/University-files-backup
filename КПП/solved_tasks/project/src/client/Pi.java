package client;

import compute.Task;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Pi implements Task<BigDecimal> {

    private final int digits;

    public Pi(int digits){
        this.digits=digits;
    }

    @Override
    public BigDecimal execute() {
        return executePi(digits);
    }

    private BigDecimal executePi(int digits){
        BigDecimal four=BigDecimal.valueOf(4);
        BigDecimal one=BigDecimal.ONE;
        BigDecimal five=new BigDecimal(5);
        BigDecimal ttn=new BigDecimal(239);
        return four.multiply(four.multiply(arctang(one.divide(five,digits,RoundingMode.HALF_UP),digits))).subtract(four.multiply(arctang(one.divide(ttn,digits,RoundingMode.HALF_UP),digits)));
    }
    private BigDecimal arctang(BigDecimal x,int scale){
        BigDecimal eps=new BigDecimal(1);
        //точность
        for(int i=0;i<scale;i++)
            eps=eps.divide(BigDecimal.TEN,scale,RoundingMode.HALF_UP);
        //вычесления
        BigDecimal res=BigDecimal.ZERO;
        BigDecimal next;
        int n=0;
        while (true) {
            next = x.pow(2*n+1).multiply(new BigDecimal(Math.pow(-1, n))).divide(new BigDecimal(2 * n + 1),scale,RoundingMode.HALF_UP);
            res = res.add(next);
            n+=1;
            if (next.abs().compareTo(eps) == -1) break;
        }
        return res;
    }
}
