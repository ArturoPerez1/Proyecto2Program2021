package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.BorderLayout;

public class JPanelContenedorCartas extends JPanel {
	
	public JPanelContenedorCartas() {
		setLayout(null);
		
		JPanel JPanelMesa = new JPanel();
		JPanelMesa.setBounds(177, 154, 614, 350);
		add(JPanelMesa);
		JPanelMesa.setLayout(null);
		
		JLabel JLabelMesaJuego = new JLabel("New label");
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("/assets/fondos/PanelCartas.jpg"));
		JLabelMesaJuego.setIcon(icon);
		JLabelMesaJuego.setBounds(0, 0, 614, 350);
		JPanelMesa.add(JLabelMesaJuego);
		
		JPanel JPanelPc = new JPanel();
		JPanelPc.setBounds(177, 0, 614, 141);
		add(JPanelPc);
		JPanelPc.setLayout(null);
		
		JLabel cartar1P = new JLabel("cartar1J");
		cartar1P.setBackground(new Color(255, 255, 153));
		cartar1P.setBounds(12, 13, 94, 115);
		JPanelPc.add(cartar1P);
		
		JLabel cartar2P = new JLabel("cartar2J");
		cartar2P.setBounds(142, 13, 94, 115);
		JPanelPc.add(cartar2P);
		
		JLabel cartar3P = new JLabel("cartar3J");
		cartar3P.setBounds(293, 13, 94, 115);
		JPanelPc.add(cartar3P);
		
		JLabel cartar4P = new JLabel("cartar4J");
		cartar4P.setBounds(458, 13, 94, 115);
		JPanelPc.add(cartar4P);
		
		JLabel JLabelCartasPc = new JLabel("New label");
		ImageIcon icon1 = new ImageIcon(Toolkit.getDefaultToolkit().getImage("/assets/fondos/PanelCartas.jpg"));
		JLabelMesaJuego.setIcon(icon1);
		JLabelCartasPc.setBounds(0, 0, 613, 161);
		JPanelPc.add(JLabelCartasPc);
		
		JPanel JPanelJugador = new JPanel();
		JPanelJugador.setBackground(new Color(255, 255, 255));
		JPanelJugador.setBounds(177, 521, 614, 141);
		add(JPanelJugador);
		JPanelJugador.setLayout(null);
		
		JLabel cartar1J = new JLabel("cartar1J");
		cartar1J.setBackground(new Color(255, 255, 153));
		cartar1J.setBounds(12, 13, 94, 115);
		JPanelJugador.add(cartar1J);
		
		JLabel cartar2J = new JLabel("cartar2J");
		cartar2J.setBounds(145, 13, 94, 115);
		JPanelJugador.add(cartar2J);
		
		JLabel cartar3J = new JLabel("cartar3J");
		cartar3J.setBounds(286, 13, 94, 115);
		JPanelJugador.add(cartar3J);
		
		JLabel cartar4J = new JLabel("cartar4J");
		cartar4J.setBounds(455, 13, 94, 115);
		JPanelJugador.add(cartar4J);
		
		JLabel JLabelCartasJugador = new JLabel("New label");
		ImageIcon icon2 = new ImageIcon(Toolkit.getDefaultToolkit().getImage("/assets/fondos/PanelCartas.jpg"));
		JLabelCartasJugador.setIcon(icon2);
		JLabelCartasJugador.setBounds(0, 0, 614, 141);
		JPanelJugador.add(JLabelCartasJugador);
		
		JLabel JLabelMaderaFondo = new JLabel("New label");
		ImageIcon icon3 = new ImageIcon(Toolkit.getDefaultToolkit().getImage("/assets/fondos/StartFondo.jpg"));
		JLabelCartasJugador.setIcon(icon3);
		JLabelMaderaFondo.setBounds(0, 0, 1024, 662);
		add(JLabelMaderaFondo);

	}
}
