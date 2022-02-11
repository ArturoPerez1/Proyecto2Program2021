package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class JPanelContenedorCartas extends JPanel {
	private JPanel _jPanelMesa;
	private JLabel _jLabelMesaJuego;
	private JPanel _jPanelPc;
	private JLabel _jLabelCartasPc;
	private JPanel _jPanelJugador;
	private JLabel _jLabelCartasJugador;
	private JLabel _jLabelMaderaFondo;
	private JLabel _cartaMesa;
	private JLabel _cartaJugador;
	private JLabel _cartaPc;
	private String _idCartaJugador;

	public String getIdCartaJugador() {
		return _idCartaJugador;
	}

	public JPanelContenedorCartas() {
		setLayout(null);

		JPanelMesa();
//        JLabelMesaJuego();
		JPanelPc();
		JLabelCartasPc();
		JPanelJugador();
		JLabelCartasJugador();
		JLabelMaderaFondo();
	}

	public JLabel getCartaMesa() {
		return _cartaMesa;
	}

	public JPanel getJPanelMesa() {
		return _jPanelMesa;
	}

	public JLabel getJLabelCartasJugador() {
		return _jLabelCartasJugador;
	}

	private void JPanelMesa() {
		_jPanelMesa = new JPanel();
		_jPanelMesa.setBounds(177, 154, 614, 350);
		add(_jPanelMesa);
		_jPanelMesa.setLayout(null);
	}

	public void CartasMesa(String imagen, int x, int y, int witdh, int height, int id, MouseListener mouseListener) {
		_cartaMesa = new JLabel();
		_cartaMesa.setBounds(x, y, witdh, height);
		ImageIcon icon = new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(imagen).getScaledInstance(witdh, height, Image.SCALE_SMOOTH));
		_cartaMesa.setIcon(icon);
		_jPanelMesa.add(_cartaMesa);
		_cartaMesa.addMouseListener(mouseListener);
	}

	private void JLabelMesaJuego() {
		_jLabelMesaJuego = new JLabel("New label");
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("assets/fondos/PanelCartas.jpg"));
		_jPanelMesa.add(_jLabelMesaJuego);
		_jLabelMesaJuego.setIcon(icon);
		_jLabelMesaJuego.setBounds(0, 0, 614, 350);
	}

	private void JPanelPc() {
		_jPanelPc = new JPanel();
		_jPanelPc.setBounds(177, 0, 614, 141);
		add(_jPanelPc);
		_jPanelPc.setLayout(null);
	}

	private void JLabelCartasPc() {
		_jLabelCartasPc = new JLabel("New label");
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("assets/fondos/PanelCartas.jpg"));
		_jLabelCartasPc.setIcon(icon);
		_jLabelCartasPc.setBounds(0, 0, 613, 161);
		_jPanelPc.add(_jLabelCartasPc);

	}

	public void CartasPc(String imagen, int x, int y, int witdh, int height) {
		_cartaPc = new JLabel();
		_cartaPc.setBounds(x, y, witdh, height);
		ImageIcon icon = new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(imagen).getScaledInstance(witdh, height, Image.SCALE_SMOOTH));
		_cartaPc.setIcon(icon);
		_jLabelCartasPc.add(_cartaPc);
	}

	private void JPanelJugador() {
		_jPanelJugador = new JPanel();
		_jPanelJugador.setBackground(new Color(255, 255, 255));
		_jPanelJugador.setBounds(177, 521, 614, 141);
		add(_jPanelJugador);
		_jPanelJugador.setLayout(null);
	}

	private void JLabelCartasJugador() {
		_jLabelCartasJugador = new JLabel("hola");
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("assets/fondos/PanelCartas.jpg"));
		_jLabelCartasJugador.setIcon(icon);
		_jLabelCartasJugador.setBounds(0, 0, 614, 141);
		_jPanelJugador.add(_jLabelCartasJugador);
	}

	public void CartasJugador(String imagen, int x, int y, int witdh, int height, int id, MouseListener mouseListener) {
		_cartaJugador = new JLabel(""+id);
		_cartaJugador.setBounds(x, y, witdh, height);
		ImageIcon icon = new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(imagen).getScaledInstance(witdh, height, Image.SCALE_SMOOTH));
		_cartaJugador.setIcon(icon);
		_jLabelCartasJugador.add(_cartaJugador);
		_cartaJugador.addMouseListener(mouseListener);
	}

	private void JLabelMaderaFondo() {
		_jLabelMaderaFondo = new JLabel("New label");
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("assets/fondos/StartFondo.jpg"));
		_jLabelMaderaFondo.setIcon(icon);
		_jLabelMaderaFondo.setBounds(0, 0, 1024, 662);
		add(_jLabelMaderaFondo);
	}
}