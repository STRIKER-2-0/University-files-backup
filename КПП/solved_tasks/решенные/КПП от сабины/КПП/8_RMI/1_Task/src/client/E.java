package client;

import compute.Task;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class E implements Task<BigDecimal> {
    private int digits;

    public E(int digits) {
        this.digits = digits;
    }

    @Override
    public BigDecimal execute() {
        return executeE(digits);
    }

    private BigDecimal executeE(int scale){
        BigDecimal eps=BigDecimal.ONE;
        //точность
        for(int i=0;i<scale;i++)
            eps=eps.divide(BigDecimal.TEN,scale,RoundingMode.HALF_UP);
        //вычесления
        BigDecimal res=BigDecimal.ZERO;
        BigDecimal next;

        int n=0;
        while (true) {
            next = BigDecimal.ONE.divide(fact(n),scale,RoundingMode.HALF_UP);
            res = res.add(next);
            n+=1;
            if (next.abs().compareTo(eps) == -1) break;
        }
        return res;
    }
    private BigDecimal fact(int n){
        BigDecimal res=BigDecimal.ONE;
        for(int i=2;i<=n;i++)
            res=res.multiply(new BigDecimal(i));
        return res;
    }
}
