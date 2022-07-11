package xyz.orangutanion;

import java.awt.Dimension;
import java.awt.Image;
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
import javax.swing.JTextArea;

public class GUI extends JFrame {

	// Needed to stop Eclipse from complaining (I'm not gonna serialize this though)
	private static final long serialVersionUID = 4647480435550859897L;
	
	// Because we want image and text to have same size, we should divide size if too large for window
	private final int sizeDenominator = 2;

	GUI() {
		super("Swing Meme");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 800);
		this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
	}
	
	public void render() {
		this.setVisible(true);
	}
	
	public void addPanel(File image, String text) {
		// Read image and turn into icon
		BufferedImage picture;
		try {
			picture = ImageIO.read(image);
		} catch (IOException e) {
			System.out.println("File " + image.toString() + " not found.");
			return;
		}
		Dimension itemSize = new Dimension
				(picture.getWidth() / sizeDenominator, picture.getHeight() / sizeDenominator);
		Image scaled = picture.getScaledInstance(itemSize.width, itemSize.height, Image.SCALE_DEFAULT);
		
		JLabel memeIcon = new JLabel(new ImageIcon(scaled));
		memeIcon.setPreferredSize(itemSize);
		
		// Generate text and format to have same size as image
		JTextArea memeText = new JTextArea(text);
		memeText.setPreferredSize(itemSize);
		memeText.setLineWrap(true);
		memeText.setEditable(false);
		
		// Add both to new panel
		JComponent memePanel = new JPanel();
		memePanel.add(memeIcon);
		memePanel.add(memeText);
		
		this.add(memePanel);
	}
}
