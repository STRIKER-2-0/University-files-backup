package client;

import compute.Compute;

import java.math.BigDecimal;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ComputePi {
    public static void main(String[] args) {
        if(System.getSecurityManager()==null)
            System.setSecurityManager(new SecurityManager());
        try {
            Registry registry=LocateRegistry.getRegistry(args[0]);
            Compute compute=(Compute)registry.lookup("Compute");
            Pi task=new Pi(Integer.parseInt(args[1]));
            BigDecimal pi=compute.executeTask(task);
            System.out.println("result= "+pi);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
