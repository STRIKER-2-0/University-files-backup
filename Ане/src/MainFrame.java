import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private ImPanel photo;
	private final int width=600;
	private final int height=700;
	private String[] pathes;
	private int now;
	private JPanel buttons;
	private JLabel label;
	private JButton next;
	private JButton back;
	private JButton sweet;
	private String[] sweets;
	private int sweetIterator;
	public JOptionPane window;
	
	public MainFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(width, height);
		setLocation(400, 20);
		setTitle("ПРАЗНИК!!))");
		
		pathes = new String[17];
		pathes[0]="AnnSleep.jpg";
		pathes[1]="aroma.jpg";
		pathes[2]="bengalFire.jpg";
		pathes[3]="chill.jpg";
		pathes[4]="fight.jpg";
		pathes[5]="hearts.jpg";
		pathes[6]="hoods.jpg";
		pathes[7]="kiss.jpg";
		pathes[8]="madness.jpg";
		pathes[9]="My.jpg";
		pathes[10]="rink.jpg";
		pathes[11]="swing.jpg";
		pathes[12]="tongues.jpg";
		pathes[13]="walk.jpg";
		pathes[14]="window.jpg";
		pathes[15]="YuSleep.jpg";
		pathes[16]="alley.jpg";
		now = pathes.length-1;
		
		photo = new ImPanel(pathes[now], width, height);
		add(photo);
		
		buttons = new JPanel();
		label = new JLabel("Фоточки: ");
		buttons.add(label);
		
		back = new JButton("<-Back");
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				now--;
				if(now == -1)
					now = pathes.length-1;
				remove(photo);
				photo = new ImPanel(pathes[now], width, height);
				add(photo);
				photo.setVisible(false);
				photo.setVisible(true);
			}
		});
		buttons.add(back);
		
		next = new JButton("Next->");
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				now++;
				if(now == pathes.length)
					now = 0;
				remove(photo);
				photo = new ImPanel(pathes[now], width, height);
				add(photo);
				photo.setVisible(false);
				photo.setVisible(true);				
			}
		});
		buttons.add(next);
		
		sweets = new String[20];
		sweets[0] = "Ты - моё самое дорогое сокровище, которым я, словно самый жадный пират, не поделюсь ни с кем)))";
		sweets[1] = "Ты - мой прекрасный лучик во тьме, который заставляет двигаться дальше и верить, что всё будет только хорошо))";
		sweets[2] = "Ты - мой бесконечный океан, в котором я порой тону, теряя голову... Но каждый раз хочу туда возвращаться)";
		sweets[3] = "Ты - моя радость и моё счастье, моя нежность и любовь♥♥♥";
		sweets[4] = "Ты - моя ясная звёздочка, самая яркая на небе, всегда указывающая мне правильный путь)";
		sweets[5] = "Ты - моя гордость, я хочу защищать и оберегать тебя";
		sweets[6] = "Ты - моя слабость, потому что тяга к тебе сбивает меня с ног и не дает покоя))";
		sweets[7] = "Ты - моя Вселенная, такая же величественная и бесконечная для познания..)";
		sweets[8] = "А также ты мой маленький и вредный котик, которого хочется просто крепко прижать к себе и неотпускать, как бы он не дергался иной раз)))";
		sweets[9] = "Ты - мой сон.. запутанный, как всегда, но прекрасный и умиротворенный.. Тебя хочется видеть вновь и вновь..)";
		sweets[10] = "Ты - мой самый лучший друг и товарищ, готовая помочь даже в самые трудные времена♥";
		sweets[11] = "Ты - моя девушка♥ ( Ну а что, нет?)) )";
		sweets[12] = "Ты - просто магия, непонятная для ума.. нов тоже время ты и наука, точная и определенная для меня..";
		sweets[13] = "Ты.. захватываешь моё дыхание, словно я падаю в бездну";
		sweets[14] = "Ты - как хорошо написанный код, мне на тебя приятно смотреть)))";
		sweets[15] = "Ты невообразима, как мои фантазии.. Хм, ты - моя фантазия)) И её я хочу фантазировать и дальше)";
		sweets[16] = "Ты\nмоё\nвсё...";
		sweets[17] = "Ты - моя королева заоблачного королевства, парящая высоко над остальными.. Я хочу быть твоим королем)";
		sweets[18] = "Ты - моё спасение в смутные времена и прилив сил в радостные♥";
		sweets[19] = "Ты - ясное небо сияющего дня, хоть иногда и делаешь вид, что тёмная тучка))";
		sweetIterator = 0;
		
		sweet = new JButton("Получить бесплантую порцию милоты♥♥♥");
		sweet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				do {
					sweetIterator = (int) (Math.random()*sweets.length);
				}while((sweetIterator >= sweets.length) && (sweetIterator < 0));
				JOptionPane.showMessageDialog(window, sweets[sweetIterator], "Милота...♥", JOptionPane.DEFAULT_OPTION);				
			}
		});
		buttons.add(sweet);
		add(buttons, BorderLayout.SOUTH);
		
		window = new JOptionPane();
		
	}
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
		JOptionPane.showMessageDialog(frame.window, "С днём рождения, любимая!\n"
				+ "Да, тут немного программистской романтики))\n"
				+ "Эта программка - для тебя, в ней наши самые яркие и милые фото,\n"
				+ "а также немного милоты от меня ;-)\n"
				+ "Наслаждайся))\n"
				+ "P.S. ты самая лучшая♥♥♥", "HAPPY BIRTHDAY))", JOptionPane.DEFAULT_OPTION);
	}
}
class ImPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image im;
	private int width;
	private int height;
	public ImPanel(String path, int width, int height){
		super();
		this.width=width;
		this.height=height;
		try {
			im=ImageIO.read(new File(path));
		} catch (IOException e) {}
	}
	public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (im==null) {
				g.drawString("Error", 0, 0);
			} else {
				g.drawImage(im, 0, 0, width, height, null);
			}
	}
}