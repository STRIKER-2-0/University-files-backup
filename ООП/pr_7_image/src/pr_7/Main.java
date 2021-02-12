package pr_7;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Main {
	public static ImPanel im_panel;
	public static String path="D:\\Загрузки\\923109.jpg";
	public static String path2="D:\\Загрузки\\927426.jpg";
	public static boolean flag=true;
	public static void main(String[] args) {
		JFrame frame=new JFrame();
		frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar bar=new JMenuBar();
		frame.setJMenuBar(bar);
		JMenu menu=new JMenu("actions"); 
		//JMenuItem, JChechBoxMenuItem, JRadioButtonMenuItem
		JMenuItem itemNew=new JMenuItem("swapFile");
		itemNew.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.remove(im_panel);
				//frame.repaint();
        		
        		if(flag) {
                	im_panel=new ImPanel(path);
                	flag=false;
        		}
                else {
                	im_panel=new ImPanel(path2);
                	flag=true;
                }
        		frame.add(im_panel, BorderLayout.CENTER);
        		im_panel.repaint();
        		frame.repaint();        		
			}
		});
		
		//JCheckBoxMenuItem itemDark=new JCheckBoxMenuItem("Dark");
		
		JMenuItem itemExit=new JMenuItem("Exit");
		bar.add(menu);
		menu.add(itemNew);
		//menu.add(itemDark);
		menu.addSeparator();
		menu.add(itemExit);
		itemExit.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});	
		im_panel=new ImPanel(path2);
        frame.add(im_panel);
        frame.setVisible(true);
		/*JMenu subs=new JMenu();
		subs.add(itemNew);
		menu.add(subs);
		menu.setMnemonic('M');
		itemExit.setAccelerator(KeyStroke.getKeyStroke("ctrl Q"));*/
	}
}
class ImPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image im;
	public ImPanel(String path){
		super();
		try {
			im=ImageIO.read(new File(path));
		} catch (IOException e) {}
	}
	public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (im==null) {
				g.drawString("Error", 0, 0);
			} else {
				//g.drawImage(im, 0, 0, null);
				g.drawImage(im, 0, 0, 1820, 1000, null);
			}
	}
}
