package functional.interfaces;

import functional.Participant;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerRegistry extends Remote {
    void register(Participant participant) throws RemoteException;
    int size()throws RemoteException;
    String getInfo() throws RemoteException;
}
