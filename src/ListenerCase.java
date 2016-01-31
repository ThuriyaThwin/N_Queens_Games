import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class ListenerCase implements MouseListener {
	private Case c;
	private int n = 8;
	static int reineAjouter = 0;
	public static ArrayList<Trone> territoire;

	public ListenerCase(Case c) {
		this.c = c;
		territoire = new ArrayList<>();

	}

	public boolean estDansLaBF(Trone t) {

		for (int i = 0; i < territoire.size(); i++) {
			if (t.equals(territoire.get(i)))
				return true;
		}
		return false;

	}

	public void territoireReine(Trone tr) {
		Trone resH = null, resV = null, resD1 = null, resD2 = null, resD3 = null, resD4 = null;
		int x, y;
		int n = 8;
		for (x = 0, y = 0; x < n && y < n; x++, y++) {
			resH = new Trone(x, tr.getY());
			resV = new Trone(tr.getX(), y);
			resD1 = new Trone(tr.getX() + x, tr.getY() + y);
			resD2 = new Trone(tr.getX() - x, tr.getY() - y);
			resD3 = new Trone(tr.getX() - x, tr.getY() + y);
			resD4 = new Trone(tr.getX() + x, tr.getY() - y);

			if (!estDansLaBF(resH))
				territoire.add(resH);
			if (!estDansLaBF(resV))
				territoire.add(resV);
			if (!estDansLaBF(resD1))
				territoire.add(resD1);
			if (!estDansLaBF(resD2))
				territoire.add(resD2);
			if (!estDansLaBF(resD3))
				territoire.add(resD3);

			if (!estDansLaBF(resD4))
				territoire.add(resD4);

		}

		System.out.print("Ajouter Territoire de " + (c.getT()).toString() + "::\n");
		for (int i = 0; i < territoire.size(); i++) {
			System.out.print(territoire.get(i).toString() + "\n");
		}
		System.out.print("Taille territoires:" + territoire.size() + "\n");
		System.out.print("------------------------------------------\n");

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		boolean reserver;
		if (SwingUtilities.isLeftMouseButton(arg0) && reineAjouter < 8) {
			if (estDansLaBF(c.getT())) {
				java.awt.Toolkit.getDefaultToolkit().beep();
			} else {
				reserver = c.select(true);
				if (reserver != false) {
					reineAjouter++;
					territoireReine(c.getT());
				}
			}
		}

		else if (SwingUtilities.isRightMouseButton(arg0)) {
			JFrame frame = new JFrame("JOptionPane showMessageDialog ");
			if (reineAjouter == 8) {
				JOptionPane.showMessageDialog(frame,
						"houraaa!!!Vous Avez Gagner :))");
				System.out.print("-->gagner");
			} else
				JOptionPane.showMessageDialog(frame,
						"Il manque encore "+(8-reineAjouter)+" reines !!!");
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
