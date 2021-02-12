package UI;

import functional.DataBaseChangeEvent;
import functional.Server;
import functional.interfaces.DataBaseChangeListener;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.security.Permission;

public class ServerFrame extends JFrame {
    private JLabel hostL,portL,participantsL;
    private JTextField hostF,portF,participantsF;
    private JButton startB,stopB,saveB,loadB;
    private JTextArea console;
    private JScrollPane scrollPane;
    private Server server;
    private Registry registry;
    private JFileChooser fileChooser;

    public static void main(String[] args) {
        if(System.getSecurityManager()==null)
            System.setSecurityManager(new SecurityManager(){
                @Override
                public void checkConnect(String host, int port, Object context) {}

                @Override
                public void checkConnect(String host, int port) {}

                @Override
                public void checkPermission(Permission perm) {}
            });
        System.setProperty("java.rmi.server.codebase","file://C:\\Users\\Максим\\Desktop\\CPP\\8_RMI\\2_Task\\out\\production\\2_Task");

        ServerFrame serverFrame=new ServerFrame();
        serverFrame.setTitle("Server");
        serverFrame.setSize(550,400);
        serverFrame.setVisible(true);
    }

    public ServerFrame(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(5,0));

        JPanel north=new JPanel(new FlowLayout());
        north.add(hostL=new JLabel("host: "));
        north.add(hostF=new JTextField(20));
        hostF.setEditable(false);
        try {
            hostF.setText(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        north.add(portL=new JLabel("port:"));
        north.add(portF=new JTextField(5));
        north.add(participantsL=new JLabel("participants: "));
        north.add(participantsF=new JTextField(5));
        participantsF.setEditable(false);
        getContentPane().add(north,BorderLayout.NORTH);

        console=new JTextArea();
        console.setEditable(false);
        scrollPane=new JScrollPane(console);
        getContentPane().add(scrollPane,BorderLayout.CENTER);

        JPanel south=new JPanel(new FlowLayout(FlowLayout.CENTER,20,5));
        south.add(startB=new JButton("Start"));
        south.add(stopB=new JButton("Stop"));
        south.add(saveB=new JButton("Save"));
        south.add(loadB=new JButton("Load"));
        stopB.setEnabled(false);saveB.setEnabled(false);
        getContentPane().add(south,BorderLayout.SOUTH);

        this.server=new Server();


        fileChooser=new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);


        startB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (registry==null) {
                        registry = LocateRegistry.createRegistry(Integer.parseInt(portF.getText()));
                        UnicastRemoteObject.exportObject(server, 0);
                        portF.setEditable(false);
                    }
                    registry.rebind("Registerable",server);

                    startB.setEnabled(false);loadB.setEnabled(false);
                    stopB.setEnabled(true);
                    if(server.getDataBase().isEmpty()) saveB.setEnabled(false); else saveB.setEnabled(true);
                }catch (NumberFormatException e1){
                    JOptionPane.showMessageDialog(ServerFrame.this,"В поле порт должны быть числа","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }catch (RemoteException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(ServerFrame.this,"Не удалось запустить","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                JOptionPane.showMessageDialog(ServerFrame.this,"Сервер начал свою работу","Success",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        stopB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    registry.unbind("Registerable");
                }catch (RemoteException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(ServerFrame.this,"Не удалось остановить","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                } catch (NotBoundException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(ServerFrame.this,"Не удалось остановить","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                JOptionPane.showMessageDialog(ServerFrame.this,"Сервер остановлен","Success",JOptionPane.INFORMATION_MESSAGE);
                startB.setEnabled(true);loadB.setEnabled(true);
                stopB.setEnabled(false);saveB.setEnabled(true);
            }
        });

        saveB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser.setDialogTitle("Выбор директории");
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fileChooser.resetChoosableFileFilters();
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.xml",  "xml"));
                if (fileChooser.showDialog(null, "Выбор директории") == JFileChooser.APPROVE_OPTION) {
                    try {
                        server.saveDoc(new File(fileChooser.getSelectedFile(), "out.xml"));
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();

                    } catch (TransformerException e1) {
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(ServerFrame.this,"Не удалось сохранить","Error",JOptionPane.ERROR_MESSAGE);
                    } catch (ParserConfigurationException e1) {
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(ServerFrame.this,"Не удалось сохранить","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        loadB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser.setDialogTitle("Выбор файла xml");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.resetChoosableFileFilters();
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.xml",  "xml"));
                File filexml,filexsd;
                if(fileChooser.showDialog(null,"Выбор файла")==JFileChooser.APPROVE_OPTION)
                    filexml=fileChooser.getSelectedFile();
                else return;
                fileChooser.resetChoosableFileFilters();
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.xsd",  "xsd"));
                fileChooser.setDialogTitle("Выбор файла xsd");
                if(fileChooser.showDialog(null,"Выбор файла")==JFileChooser.APPROVE_OPTION)
                    filexsd=fileChooser.getSelectedFile();
                else return;
                server.fillDoc(filexml,filexsd);
            }
        });

        server.getDataBase().addDataSheetChangeListener(new DataBaseChangeListener() {
            @Override
            public void dataChanged(DataBaseChangeEvent e) {
                console.setText("Participants:\r\n"+server.getDataBase().toString());
                participantsF.setText(String.valueOf(server.getDataBase().size()));
            }
        });
    }
}
