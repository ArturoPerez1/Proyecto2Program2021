package vista;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class JPanelContenedorCartas extends JPanel {
	private JPanel JPanelMesa;
	private JLabel JLabelMesaJuego;
	private JPanel JPanelPc;
	private JLabel JLabelCartasPc;
	private JPanel JPanelJugador;
	private JLabel JLabelCartasJugador;
	private JLabel JLabelMaderaFondo;
	private JLabel carta1M;
	private JLabel carta2M;
	private JLabel carta3M;
	private JLabel carta4M;
	private JLabel carta5M;
	private JLabel carta6M;
	private JLabel carta7M;
	private JLabel carta8M;
	private JLabel carta9M;
	private JLabel carta10M;
	private JLabel carta1P;
	private JLabel carta2P;
	private JLabel carta3P;
	private JLabel carta4P;
	private JLabel carta1J;
	private JLabel carta2J;
	private JLabel carta3J;
	private JLabel carta4J;

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

	public void setCartar1P(String imagen) {
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(imagen).getScaledInstance(82, 101, Image.SCALE_SMOOTH));
		carta1P.setIcon(icon);
		carta1P.removeAll();
		carta1P.revalidate();
		carta1P.repaint();
	}

	public void setCartar2P(String imagen) {
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(imagen).getScaledInstance(82, 101, Image.SCALE_SMOOTH));
		carta2P.setIcon(icon);
		carta2P.removeAll();
		carta2P.revalidate();
		carta1J.repaint();
	}

	public void setCartar3P(String imagen) {
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(imagen).getScaledInstance(82, 101, Image.SCALE_SMOOTH));
		carta3P.setIcon(icon);
		carta3P.removeAll();
		carta3P.revalidate();
		carta1J.repaint();
	}

	public void setCartar4P(String imagen) {
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(imagen).getScaledInstance(82, 101, Image.SCALE_SMOOTH));
		carta4P.setIcon(icon);
		carta4P.removeAll();
		carta4P.revalidate();
		carta1J.repaint();
	}

	public void setCartar1J(String imagen) {
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(imagen).getScaledInstance(82, 101, Image.SCALE_SMOOTH));
		carta1J.setIcon(icon);
		carta1J.removeAll();
		carta1J.revalidate();
		carta1J.repaint();
	}

	public void setCartar2J(String imagen) {
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(imagen).getScaledInstance(82, 101, Image.SCALE_SMOOTH));
		carta2J.setIcon(icon);
		carta2J.removeAll();
		carta2J.revalidate();
		carta2J.repaint();
	}

	public void setCartar3J(String imagen) {
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(imagen).getScaledInstance(82, 101, Image.SCALE_SMOOTH));
		carta3J.setIcon(icon);
		carta3J.removeAll();
		carta3J.revalidate();
		carta3J.repaint();
	}

	public void setCartar4J(String imagen) {
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(imagen).getScaledInstance(82, 101, Image.SCALE_SMOOTH));
		carta4J.setIcon(icon);
		carta4J.removeAll();
		carta4J.revalidate();
		carta4J.repaint();
	}

	public void setCarta1M(String imagen) {
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(imagen).getScaledInstance(82, 101, Image.SCALE_SMOOTH));
		carta1M.setIcon(icon);
		carta1M.removeAll();
		carta1M.revalidate();
		carta1M.repaint();
	}

	public void setCarta2M(String imagen) {
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(imagen).getScaledInstance(82, 101, Image.SCALE_SMOOTH));
		carta2M.setIcon(icon);
		carta2M.removeAll();
		carta2M.revalidate();
		carta2M.repaint();
	}

	public void setCarta3M(String imagen) {
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(imagen).getScaledInstance(82, 101, Image.SCALE_SMOOTH));
		carta3M.setIcon(icon);
		carta3M.removeAll();
		carta3M.revalidate();
		carta3M.repaint();
	}

	public void setCarta4M(String imagen) {
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(imagen).getScaledInstance(82, 101, Image.SCALE_SMOOTH));
		carta4M.setIcon(icon);
		carta4M.removeAll();
		carta4M.revalidate();
		carta4M.repaint();
	}

	public void setCarta5M(String imagen) {
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(imagen).getScaledInstance(82, 101, Image.SCALE_SMOOTH));
		carta5M.setIcon(icon);
		carta5M.removeAll();
		carta5M.revalidate();
		carta5M.repaint();
	}

	public void setCarta6M(String imagen) {
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(imagen).getScaledInstance(82, 101, Image.SCALE_SMOOTH));
		carta6M.setIcon(icon);
		carta6M.removeAll();
		carta6M.revalidate();
		carta6M.repaint();
	}

	public void setCarta7M(String imagen) {
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(imagen).getScaledInstance(82, 101, Image.SCALE_SMOOTH));
		carta7M.setIcon(icon);
		carta7M.removeAll();
		carta7M.revalidate();
		carta7M.repaint();
	}

	public void setCarta8M(String imagen) {
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(imagen).getScaledInstance(82, 101, Image.SCALE_SMOOTH));
		carta8M.setIcon(icon);
		carta8M.removeAll();
		carta8M.revalidate();
		carta8M.repaint();
	}

	public void setCarta9M(String imagen) {
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(imagen).getScaledInstance(82, 101, Image.SCALE_SMOOTH));
		carta9M.setIcon(icon);
		carta9M.removeAll();
		carta9M.revalidate();
		carta9M.repaint();
	}

	public void setCarta10M(String imagen) {
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(imagen).getScaledInstance(82, 101, Image.SCALE_SMOOTH));
		carta10M.setIcon(icon);
		carta10M.removeAll();
		carta10M.revalidate();
		carta10M.repaint();
		carta10M.setIcon(icon);
	}

	private void JPanelMesa() {
		JPanelMesa = new JPanel();
		JPanelMesa.setBounds(177, 154, 614, 350);
		add(JPanelMesa);
		JPanelMesa.setLayout(null);
		cartasDeLaMesa();
	}

	private void cartasDeLaMesa() {
		carta1M = new JLabel("New label");
		carta1M.setBounds(12, 24, 82, 101);
		JPanelMesa.add(carta1M);
		carta1M.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		carta2M = new JLabel("New label");
		carta2M.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		carta2M.setBounds(138, 24, 82, 101);
		JPanelMesa.add(carta2M);

		carta3M = new JLabel("New label");
		carta3M.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		carta3M.setBounds(255, 24, 82, 101);
		JPanelMesa.add(carta3M);

		carta4M = new JLabel("New label");
		carta4M.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		carta4M.setBounds(375, 24, 82, 101);
		JPanelMesa.add(carta4M);

		carta5M = new JLabel("New label");
		carta5M.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		carta5M.setBounds(502, 24, 82, 101);
		JPanelMesa.add(carta5M);

		carta6M = new JLabel("New label");
		carta6M.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		carta6M.setBounds(25, 167, 82, 101);
		JPanelMesa.add(carta6M);

		carta7M = new JLabel("New label");
		carta7M.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		carta7M.setBounds(136, 167, 84, 101);
		JPanelMesa.add(carta7M);

		carta8M = new JLabel("New label");
		carta8M.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		carta8M.setBounds(255, 167, 82, 101);
		JPanelMesa.add(carta8M);

		carta9M = new JLabel("New label");
		carta9M.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		carta9M.setBounds(375, 167, 82, 101);
		JPanelMesa.add(carta9M);

		carta10M = new JLabel("New label");
		carta10M.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		carta10M.setBounds(502, 167, 82, 101);
		JPanelMesa.add(carta10M);
	}

	private void JLabelMesaJuego() {
		JLabelMesaJuego = new JLabel("New label");
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("assets/fondos/PanelCartas.jpg"));
		JPanelMesa.add(JLabelMesaJuego);
		JLabelMesaJuego.setIcon(icon);
		JLabelMesaJuego.setBounds(0, 0, 614, 350);
	}

	private void JPanelPc() {
		JPanelPc = new JPanel();
		JPanelPc.setBounds(177, 0, 614, 141);
		add(JPanelPc);
		JPanelPc.setLayout(null);

		cartasPC();
	}

	private void cartasPC() {
		carta1P = new JLabel("cartar1J");
		carta1P.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		carta1P.setBounds(38, 13, 82, 101);
		JPanelPc.add(carta1P);

		carta2P = new JLabel("cartar2J");
		carta2P.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		carta2P.setBounds(180, 13, 82, 101);
		JPanelPc.add(carta2P);

		carta3P = new JLabel("cartar3J");
		carta3P.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		carta3P.setBounds(319, 13, 82, 101);
		JPanelPc.add(carta3P);

		carta4P = new JLabel("cartar4J");
		carta4P.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		carta4P.setBounds(458, 13, 82, 101);
		JPanelPc.add(carta4P);
	}

	private void JLabelCartasPc() {
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

		cartasJugador();
	}

	private void cartasJugador() {
		carta1J = new JLabel("cartar1J");
		carta1J.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		carta1J.setBounds(51, 13, 82, 101);
		JPanelJugador.add(carta1J);

		carta2J = new JLabel("cartar2J");
		carta2J.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		carta2J.setBounds(192, 13, 82, 101);
		JPanelJugador.add(carta2J);

		carta3J = new JLabel("cartar3J");
		carta3J.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		carta3J.setBounds(326, 13, 82, 101);
		JPanelJugador.add(carta3J);

		carta4J = new JLabel("cartar4J");
		carta4J.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		carta4J.setBounds(455, 13, 82, 101);
		JPanelJugador.add(carta4J);
	}

	private void JLabelCartasJugador() {
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
