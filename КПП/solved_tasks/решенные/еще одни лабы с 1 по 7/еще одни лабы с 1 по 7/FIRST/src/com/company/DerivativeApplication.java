package com.company;


import java.io.*;

public class DerivativeApplication {
    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        Evaluatable functs[] = new Evaluatable[3];
        functs[0] = new FFunction(0.5);
        functs[1] = new SolveEqFunction(); //зависимость решения уравнения (sech(x)^2=a*x) от параеметра а
        functs[2] = new FileListInterpolation();  //в этом классе : конструктор по умолч., методы считыв инф-ции о точках
        ((SolveEqFunction) functs[1]).setRootApprox(0.7);  // приближенное значение
        try {
            ((FileListInterpolation) functs[2]).readFromFile("TblFnc.dat");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(-1);
        }

        String fileName = "";
        for (Evaluatable f : functs) {
            System.out.println("�������: " + f.getClass().getSimpleName());
            fileName = f.getClass().getSimpleName() + ".dat";
            PrintWriter out = new PrintWriter(new FileWriter(fileName));
            for (double x = 1.5; x <= 6.5; x += 0.05) {
                System.out.println("x: " + x + "\tf: " + f.evalf(x) + "\tf': " + NumMethods.der(x, 1.0e-4, f));
                out.printf("%16.6e%16.6e%16.6e\n", x, f.evalf(x), NumMethods.der(x, 1.0e-4, f));
            }
            System.out.println("\n");
            out.close();
        }
    }
}
