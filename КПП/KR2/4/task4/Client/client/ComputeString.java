package client;

import compute.Compute;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.math.BigDecimal;
import java.util.Scanner;

public class ComputeString {
    public static void main(String args[]) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            Registry registry = LocateRegistry.getRegistry(args[0]);
            String name = "Compute";
            Compute comp = (Compute) registry.lookup(name);

            System.out.println("Input String :");
            Scanner sc = new Scanner(System.in);
            DoubledString task = new DoubledString(sc.nextLine());

            String str = comp.executeTask(task);
            System.out.println(str);
        } catch (Exception e) {
            System.err.println("ComputeString exception:");
            e.printStackTrace();
        }
    }
}
