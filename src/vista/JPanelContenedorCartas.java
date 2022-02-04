package vista;

import javax.swing.*;
import java.awt.*;

public class JPanelContenedorCartas extends JPanel {
	private JPanel JPanelMesa;
	private JLabel JLabelMesaJuego;
	private JPanel JPanelPc;
	private JLabel JLabelCartasPc;
	private JPanel JPanelJugador;
	private JLabel JLabelCartasJugador;
	private JLabel JLabelMaderaFondo;

	public JPanelContenedorCartas() {
		setLayout(null);

		JPanelMesa();
		JLabelMesaJuego();
		JPanelPc();
		JLabelCartasPc();
		JPanelJugador();
		JLabelCartasJugador();
		JLabelMaderaFondo();
	}

	private void JPanelMesa() {
		JPanelMesa = new JPanel();
		JPanelMesa.setBounds(177, 154, 614, 350);
		add(JPanelMesa);
		JPanelMesa.setLayout(null);
	}

	private void JLabelMesaJuego() {
		JLabelMesaJuego = new JLabel("New label");
        ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("assets/fondos/PanelCartas.jpg"));
		JLabelMesaJuego.setIcon(icon);
		JLabelMesaJuego.setBounds(0, 0, 614, 350);
		JPanelMesa.add(JLabelMesaJuego);
	}

	private void JPanelPc() {
		JPanelPc = new JPanel();
		JPanelPc.setBounds(177, 0, 614, 141);
		add(JPanelPc);
		JPanelPc.setLayout(null);
	}

	private void JLabelCartasPc() {
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

		JLabelCartasPc = new JLabel("New label");
        ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("assets/fondos/PanelCartas.jpg"));
        JLabelCartasPc.setIcon(icon);
		JLabelCartasPc.setBounds(0, 0, 613, 161);
		JPanelPc.add(JLabelCartasPc);
	}

	private void JPanelJugador() {
		JPanelJugador = new JPanel();
		JPanelJugador.setBackground(new Color(255, 255, 255));
		JPanelJugador.setBounds(177, 521, 614, 141);
		add(JPanelJugador);
		JPanelJugador.setLayout(null);
	}

	private void JLabelCartasJugador() {
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
				
		JLabelCartasJugador = new JLabel("New label");
        ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("assets/fondos/PanelCartas.jpg"));
		JLabelCartasJugador.setIcon(icon);
		JLabelCartasJugador.setBounds(0, 0, 614, 141);
		JPanelJugador.add(JLabelCartasJugador);
	}

	private void JLabelMaderaFondo() {
		JLabelMaderaFondo = new JLabel("New label");
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("assets/fondos/StartFondo.jpg"));
		JLabelMaderaFondo.setIcon(icon);
		JLabelMaderaFondo.setBounds(0, 0, 1024, 662);
		add(JLabelMaderaFondo);
	}
}
