import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;

public class Window extends JFrame {
    private DataSheetTablePanel dataSheetTablePanel;
    private DataSheetGraph dataSheetGraph;
    private JPanel buttonPanel;
    private JButton openButton,saveButton,clearButton,exitButton;
    private JFileChooser fileChooser;
    private JCheckBox checkBox;

    public static void main(String[] args) {
        Window window=new Window();
        window.setSize(900,600);
        window.setVisible(true);
    }

    public Window(){
        setTitle("JavaBean");
        getContentPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        dataSheetTablePanel=new DataSheetTablePanel();
        this.getContentPane().add(dataSheetTablePanel,BorderLayout.WEST);


        dataSheetGraph=new DataSheetGraph();
        this.add(dataSheetGraph,BorderLayout.CENTER);

        buttonPanel=new JPanel(new FlowLayout(FlowLayout.CENTER,25,5));
        buttonPanel.add(openButton=new JButton("Открыть"));
        buttonPanel.add(saveButton=new JButton("Сохранить"));
        buttonPanel.add(clearButton=new JButton("Очистить"));
        buttonPanel.add(exitButton=new JButton("Завершить"));
        buttonPanel.add(checkBox=new JCheckBox("Соеденить линией"));
        this.add(buttonPanel,BorderLayout.SOUTH);

        fileChooser=new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.xml",  "xml"));

        openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileChooser.setDialogTitle("Выбор файла");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                if(fileChooser.showDialog(null,"Выбор файла")==JFileChooser.APPROVE_OPTION)
                    try {
                        DataSheet dataSheet=new DataSheet();
                        dataSheet.fillDocument(fileChooser.getSelectedFile());
                        dataSheetTablePanel.getDataSheetTable().getModel().setDataSheet(dataSheet);
                        dataSheetTablePanel.getDataSheetTable().revalidate();
                    } catch (ParserConfigurationException e1) {
                        e1.printStackTrace();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (TransformerException e1) {
                        e1.printStackTrace();
                    }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser.setDialogTitle("Выбор директории");
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                if(fileChooser.showDialog(null,"Выбор директории")==JFileChooser.APPROVE_OPTION)
                    try {
                        dataSheetTablePanel.getDataSheetTable().getModel().getDataSheet().saveDocument(new File(fileChooser.getSelectedFile(),"out.xml"));
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (TransformerException e1) {
                        e1.printStackTrace();
                    }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dataSheetTablePanel.getDataSheetTable().getModel().clearDataSheet();
                dataSheetTablePanel.getDataSheetTable().revalidate();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        dataSheetTablePanel.getDataSheetTable().getModel().addDataSheetChangeListener(new DataSheetChangeListener() {
            @Override
            public void dataChanged(DataSheetChangeEvent e) {
                dataSheetGraph.setDataSheet(dataSheetTablePanel.getDataSheetTable().getModel().getDataSheet());
                dataSheetGraph.repaint();
            }

        });
        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                dataSheetGraph.setConnected(checkBox.isSelected());
                dataSheetGraph.repaint();
            }
        });
    }
}
