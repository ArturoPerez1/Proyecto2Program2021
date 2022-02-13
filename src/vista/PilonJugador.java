package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PilonJugador extends JFrame {

	private JPanel panelContenedor;
	private JLabel cartaPilon;


	public PilonJugador() {
        setResizable(false);
        setSize(1030, 697);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBackground(Color.GRAY);
        setTitle("Ventana secundaria");
        panelContenedor = new JPanel();
        panelContenedor.setBounds(0, 0, 1024, 662);
        getContentPane().add(panelContenedor);
        panelContenedor.setLayout(null);
		setVisible(true);
	}
	
	public void MostrarNada() {
		JLabel cartaPilon1 = new JLabel(" nada");
		cartaPilon1.setBounds(0, 10, 20, 40);
		getContentPane().add(cartaPilon1);
	}
	public void MostrarPilon(String imagen, int x, int y, int witdh, int height, int id) {
		cartaPilon = new JLabel("" + id);
		cartaPilon.setBounds(x, y, witdh, height);
		ImageIcon icon = new ImageIcon(
				Toolkit.getDefaultToolkit().getImage("assets/cartas/"+imagen).getScaledInstance(witdh, height, Image.SCALE_SMOOTH));
		cartaPilon.setIcon(icon);
		panelContenedor.add(cartaPilon);
	}

}
