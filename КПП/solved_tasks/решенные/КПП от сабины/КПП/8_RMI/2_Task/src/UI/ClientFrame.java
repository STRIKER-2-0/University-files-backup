package UI;

import functional.Participant;
import functional.interfaces.ServerRegistry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientFrame extends JFrame {
    private JLabel hostL,portL,participantsL;
    private JTextField hostF,portF,participantsF;
    private JLabel nameL,surnameL,organizationL,reportL,emainL;
    private JTextField nameF,surnameF,organizationF,reportF,emainF;
    private JButton registerB,clearB,getInfoB;


    public static void main(String[] args) {
        ClientFrame clientFrame=new ClientFrame();
        clientFrame.setTitle("Client");
        clientFrame.setSize(550,250);
        clientFrame.setVisible(true);
        clientFrame.setResizable(false);
    }

    public ClientFrame(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(5,0));

        JPanel north=new JPanel();
        north.setLayout(new BoxLayout(north,BoxLayout.X_AXIS));
        north.add(hostL=new JLabel("host: "));
        north.add(hostF=new JTextField(20));
        hostF.setText("localhost");
        north.add(portL=new JLabel("port:"));
        north.add(portF=new JTextField(5));
        portF.setText("1234");
        north.add(participantsL=new JLabel("participants: "));
        north.add(participantsF=new JTextField(5));
        participantsF.setEditable(false);
        getContentPane().add(north,BorderLayout.NORTH);

        //Центр
        JPanel regLines=new JPanel();
        GroupLayout layout=new GroupLayout(regLines);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);

        GroupLayout.SequentialGroup hGroup=layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup().addComponent(nameL=new JLabel("Name: ")).addComponent(surnameL=new JLabel("Surname: ")).addComponent(organizationL=new JLabel("Organization: ")).addComponent(reportL=new JLabel("Report")).addComponent(emainL=new JLabel("e-mail: ")));
        hGroup.addGroup(layout.createParallelGroup().addComponent(nameF=new JTextField()).addComponent(surnameF=new JTextField()).addComponent(organizationF=new JTextField()).addComponent(reportF=new JTextField()).addComponent(emainF=new JTextField()));
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup=layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(nameL).addComponent(nameF));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(surnameL).addComponent(surnameF));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(organizationL).addComponent(organizationF));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(reportL).addComponent(reportF));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(emainL).addComponent(emainF));
        layout.setVerticalGroup(vGroup);
        regLines.setLayout(layout);
        getContentPane().add(regLines,BorderLayout.CENTER);

        //низ
        JPanel south=new JPanel(new FlowLayout(FlowLayout.CENTER));
        south.add(registerB=new JButton("Register"));
        south.add(clearB=new JButton("Clear"));
        south.add(getInfoB=new JButton("Get Info"));
        getContentPane().add(south,BorderLayout.SOUTH);

        registerB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Registry registry=LocateRegistry.getRegistry(hostF.getText(),Integer.parseInt(portF.getText()));
                    Participant participant=new Participant(nameF.getText(),surnameF.getText(),organizationF.getText(),reportF.getText(),emainF.getText());
                    ((ServerRegistry)registry.lookup("Registerable")).register(participant);
                } catch (NumberFormatException e1){
                    JOptionPane.showMessageDialog(ClientFrame.this,"В поле порт должны быть числа","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }catch (RemoteException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(ClientFrame.this,"Не удалось отправить","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                } catch (NotBoundException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(ClientFrame.this,"Не удалось отправить","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        });

        clearB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameF.setText("");surnameF.setText("");
                organizationF.setText("");reportF.setText("");
                emainF.setText("");
            }
        });

        getInfoB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Registry registry = LocateRegistry.getRegistry(hostF.getText(),Integer.parseInt(portF.getText()));
                    new InformFrame(((ServerRegistry)registry.lookup("Registerable")).getInfo());
                    participantsF.setText(String.valueOf(((ServerRegistry)registry.lookup("Registerable")).size()));
                }catch (NumberFormatException e1){
                    JOptionPane.showMessageDialog(ClientFrame.this,"В поле порт должны быть числа","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }catch (RemoteException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(ClientFrame.this,"Не удалось получить информацию","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                } catch (NotBoundException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(ClientFrame.this,"Не удалось получить информацию","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }


            }
        });
    }
}
