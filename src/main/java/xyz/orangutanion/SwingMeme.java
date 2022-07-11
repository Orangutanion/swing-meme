package xyz.orangutanion;

import java.io.File;

class SwingMeme {
	public static void main(String[] args) {
		GUI meme = new GUI();
		meme.addPanel(new File("src/assets/expand01.png"), "creating a meme in photoshop/gimp/krita/whatever");
		meme.addPanel(new File("src/assets/expand02.png"), "creating a meme in Windows Forms with Visual Studio");
		meme.addPanel(new File("src/assets/expand03.png"), "creating a meme in Java with Swing");
		meme.addPanel(new File("src/assets/expand04.png"), "hosting your meme's source code on your own GitHub");
		meme.render();
	}
}