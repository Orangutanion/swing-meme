package xyz.orangutanion;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI extends JFrame {

	// Needed to stop Eclipse from complaining (I'm not gonna serialize this though)
	private static final long serialVersionUID = 4647480435550859897L;

	GUI() {
		super("Swing Meme");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		try {
			this.add(memeText(new File("src/assets/expand01.png"), "quack"));
		}
		catch(IOException e) {
			System.out.println("Image not found");
		}
	}
	
	public void render() {
		this.setVisible(true);
	}
	
	private JComponent memeText(File image, String text) throws IOException {
		// Read image and turn into icon
		BufferedImage picture = ImageIO.read(image);
		JLabel memeIcon = new JLabel(new ImageIcon(picture));
		
		// Generate text
		JLabel memeText = new JLabel(text);
		
		// Add both to new panel
		JComponent memePanel = new JPanel();
		memePanel.add(memeIcon);
		memePanel.add(memeText);
		
		return memePanel;
	}
}
