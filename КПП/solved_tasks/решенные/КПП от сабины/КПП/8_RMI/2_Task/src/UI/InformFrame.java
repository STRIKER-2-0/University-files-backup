package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InformFrame extends JFrame {
    private JLabel label;
    private JScrollPane scrollPane;
    private JTextArea textArea;

    public InformFrame(String inform){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(label=new JLabel("Inform: "),BorderLayout.CENTER);

        textArea=new JTextArea();
        textArea.setText(inform);
        scrollPane=new JScrollPane(textArea);

        getContentPane().add(scrollPane,BorderLayout.CENTER);

        setTitle("Client");
        setSize(550,250);
        setVisible(true);
        setResizable(false);

    }
}
