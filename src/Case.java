import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Paint;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class Case extends JPanel {

	Couleur couleur;
	Image image;
	private Trone t;
	int countClick = 0;
	

	public Case(Trone tn) {
		
		this.t=tn;
		int x = t.getX();
		int y = t.getY();
		
		setLayout(new GridLayout(1, 0));
		ImageIcon icon;
		if ((y % 2 == 0 && x % 2 == 0) || (y % 2 != 0 && x % 2 != 0)) {
			this.couleur = Couleur.BLANC;
			// setBackground(Color.white);
			// setForeground(new Color(200, 200, 200));
			icon = chargerIcone("caseBlanche.jpg");

		} else {
			this.couleur = Couleur.NOIR;
			// setBackground(Color.black);
			// setForeground(new Color(20, 20, 20));
			icon = chargerIcone("caseNoire.jpg");
		}
		this.image = icon.getImage();

	}

	/*
	 * public void paintComponent(Graphics g){ Paint paint; Graphics2D g2d; if
	 * (g instanceof Graphics2D) { g2d = (Graphics2D) g; } else {
	 * System.out.println("Error"); return; } paint = new GradientPaint(0,0,
	 * getBackground(), getWidth(), getHeight(), getForeground());
	 * g2d.setPaint(paint); g.fillRect(0, 0, getWidth(), getHeight()); }
	 */

	public Trone getT() {
		return t;
	}

	public void setT(Trone t) {
		this.t = t;
	}

	public ImageIcon chargerIcone(String nomFichier) {

		String nomCompletFichier = "/images/" + nomFichier;
		URL url = Case.class.getResource(nomCompletFichier);
		ImageIcon icon = url != null ? new ImageIcon((URL) url)
				: new ImageIcon("null");
		if (icon == null) {
			System.out.println("impossible de trouver le fichier " + nomFichier+ "\n");
			System.exit(-1);
		}
		return icon;
	}

	public boolean select(Boolean ajouter) {
		JLabel picLabel = new JLabel(chargerIcone("RB.png"));
		if (ajouter == true) {
			if (countClick == 0) {
				add(picLabel);
				revalidate();
				// territoireDuneAutreReine(t);
				countClick++;
			}
			else return false;
			
		} else {
			removeAll();
			repaint();
			repaint();
			countClick = 0;
		}
		return true;
	}

	

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // paint background
		if (image != null) { // there is a picture: draw it
			int height = this.getSize().height;
			int width = this.getSize().width;
			// g.drawImage(image, 0, 0, this); //use image size
			g.drawImage(image, 0, 0, width, height, this);
		}
	}

}
