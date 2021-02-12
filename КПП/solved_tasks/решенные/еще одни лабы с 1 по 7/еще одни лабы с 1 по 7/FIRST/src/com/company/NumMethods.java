package com.company;


public class NumMethods {
    private NumMethods() {
        // TODO Auto-generated constructor stub
    }

    private static double meth(double x, double h, Evaluatable f) {
        return 0.5 * (f.evalf(x + h) - f.evalf(x - h)) / h;
    }

    public static double der(double x, double tol, Evaluatable f) {
        final int MAX = 100;
        double h = 0.1;
        double one = meth(x, h, f);
        h = 0.1 * h;
        double two = meth(x, h, f);
        int i = 0;
        double tmp;
        boolean ok;
        do {
            h = 0.1 * h;
            tmp = meth(x, h, f);
            ok = (Math.abs(tmp - two) >= Math.abs(two - one)) || (Math.abs(two - one) < tol);
            if (i > MAX) {
                System.out.print("Слишком много шагов вычислений");
                System.exit(-1);
            }
            i += 1;
            one = two;
            two = tmp;
        } while (!ok);
        return two;
    }

    public static double findRoot(double appr, double eps, Evaluatable f) {
        final int MAX_ITER = 100;
        int k = 0;
        double delta = 1.0e-1 * appr;
        double old1 = appr, old2 = appr + delta;
        double res, error;
        do {
            k += 1;
            res = old2 - f.evalf(old2) * (old1 - old2) / (f.evalf(old1) - f.evalf(old2));
            error = Math.abs(res - old2);
            old1 = old2;
            old2 = res;
            if (k > MAX_ITER) {
                System.out.print("Слишком много шагов вычислений");
                System.exit(-1);
            }
        } while (error >= eps);
        return res;
    }
}