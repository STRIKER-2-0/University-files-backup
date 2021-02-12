import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UI extends JFrame {
    public static void main(String[] args) {
        UI frame=new UI();
        frame.setVisible(true);
    }

    private JLabel label;
    private JTextField strClass;
    private JScrollPane scrollPane;
    private JButton analys,clear;
    private JTextArea res;

    public UI(){
        super("Анализатор класса");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
        setSize(new Dimension(500,500));

        JPanel n=new JPanel(new BorderLayout());
        n.add(label=new JLabel("Введите полное имя класса:"),BorderLayout.WEST);
        n.add(strClass=new JTextField(),BorderLayout.CENTER);
        getContentPane().add(n,BorderLayout.NORTH);

        getContentPane().add(scrollPane=new JScrollPane(res=new JTextArea()),BorderLayout.CENTER);

        JPanel butPan=new JPanel();
        butPan.add(analys=new JButton("Анализ"));
        butPan.add(clear=new JButton("Очистить"));
        getContentPane().add(butPan,BorderLayout.SOUTH);

        analys.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                res.setText(Analys.res(strClass.getText()));
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                res.setText("");
            }
        });
    }
}
