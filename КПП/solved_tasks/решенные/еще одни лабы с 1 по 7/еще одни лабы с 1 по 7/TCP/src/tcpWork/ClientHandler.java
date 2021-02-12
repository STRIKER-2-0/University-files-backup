package tcpWork;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler extends Thread{
    private ObjectInputStream in = null;
    private ObjectOutputStream out = null;
    private boolean work = true;
    private MetroCardBank bnk = null;
    private Socket s = null;

    public ClientHandler(MetroCardBank bnk, Socket s){
        this.bnk = bnk;
        this.s = s;
        this.work = true;
        try{
            this.in = new ObjectInputStream(s.getInputStream()); 
            this.out = new ObjectOutputStream(s.getOutputStream());
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }


    @Override
    public void run() {
        synchronized (bnk){
            System.out.println("Client Handler Started for: " + s);
            while (work){
                Object obj;
                try{
                    obj = in.readObject();
                    processOperation(obj);
                } catch (IOException e) {
                    System.out.println("Error: " + e);
                } catch (ClassNotFoundException e) {
                    System.out.println("Error: " + e);
                }
            }

            try{
                System.out.println("Client Handler Stopped for: " + s);
                s.close(); // Р—Р°РєСЂС‹РІР°РµРј СЃРѕРєРµС‚
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }
    }


    public void processOperation(Object obj) throws IOException {
        if(obj instanceof StopOperation){
            finish();
        } else if(obj instanceof AddMetroCardOperation){
            addCard(obj);
        } else if(obj instanceof AddMoneyOperation){
            addMoney(obj);
        } else if(obj instanceof PayMoneyOperation){
            payMoney(obj);
        } else if(obj instanceof RemoveCardOperation){
            removeCard(obj);
        } else if(obj instanceof ShowBalanceOperation){
            showBalance(obj);
        } else if(obj instanceof  ShowCardInfoOperation){
            showInfo(obj);
        } else error();
    }


    private void addCard(Object obj) throws IOException {
       
        bnk.addCard(((AddMetroCardOperation) obj).getCrd());
        out.writeObject("Card Added"); 
        out.flush(); 
    }

    private void addMoney(Object obj) throws IOException{
        AddMoneyOperation op = (AddMoneyOperation) obj;
        boolean success =
                bnk.addMoney(op.getId(),op.getMoney());

        if (success){
            out.writeObject("Balance Added Successfully!");
            out.flush();
        } else{
            out.writeObject("--ERROR 309--\nDescription: Could Not Add Balance");
            out.flush();
        }
    }


    private void payMoney(Object obj) throws IOException{
        PayMoneyOperation op = (PayMoneyOperation) obj;
        boolean success =
                bnk.getMoney(op.getId(),op.getMoney()); 
        if (success){
            out.writeObject("Payment Was Successful!");
            out.flush();
        } else{
            out.writeObject("--ERROR 310--\nDescription: Payment Failed");
            out.flush();
        }
    }


    private void removeCard(Object obj) throws IOException{
        RemoveCardOperation op = (RemoveCardOperation) obj;
        boolean success =
                bnk.removeCard(op.getId()); 
        if(success){
            out.writeObject("Card в„– " + op.getId() + " Removed Successfully!");
            out.flush();
        } else{
            out.writeObject("--ERROR 311--\nDescription: Could Not Remove Card: " + op.getId());
            out.flush();
        }
    }


    private void showBalance(Object obj) throws IOException{
        ShowBalanceOperation op = (ShowBalanceOperation) obj;
        int index = bnk.findMetroCard(op.getId()); 
        if (index >= 0){
            out.writeObject("Card: " + op.getId() + "\nBalance: " + bnk.getStore().get(index).getBalance());
            out.flush();
        } else{
            out.writeObject("--ERROR 312--\nDescription: Requested Card в„–" + op.getId() + " Was Not Found");
            out.flush();
        }

    }


    private void showInfo(Object obj) throws IOException{
        ShowCardInfoOperation op = (ShowCardInfoOperation) obj;
        int index = bnk.findMetroCard(op.getId()); 
        if (index >= 0){
            out.writeObject(bnk.getStore().get(index).toString());
            out.flush();
        } else{
            out.writeObject("--ERROR 312--\nDescription: Requested Card в„–" + op.getId() + " Was Not Found");
            out.flush();
        }
    }


    private void finish() throws IOException {
        work = false; 
        out.writeObject("Finish Work " + s); 
        out.flush(); 
    }

    private void error() throws IOException{
        out.writeObject("--ERROR 300--\nDescription: Impossible Card Operation");
        out.flush();
    }
}
