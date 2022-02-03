package vista;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.peer.LabelPeer;
import javax.swing.border.MatteBorder;

import modelo.ControladorDeArchivos;

import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class Vista extends JFrame {
	private JPanel panel1;
	private JLabel nuevaPartida;
	private JLabel cargarPartida;
	private JLabel labelSalir;
	private JLabel menuPrincipal;
	private JPanel panel2;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JPanelInicioJuego panelJuego;
	private JPanel panelContenedor;
	private PanelRecibirNombre recibir;
	private String textoJTextField;

	public Vista() {
		setResizable(false);
		setSize(1030, 697);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(Color.GRAY);
		setTitle("Ventana Principal");
		getContentPane().setLayout(null);
		panelContenedor = new JPanel();
		panelContenedor.setBounds(0, 0, 1024, 662);
		getContentPane().add(panelContenedor);

		iniciarComponetes();
	}

	public String getTextoJTextField() {
		return recibir.getRecibirNombreJugador().getText();
	}

	private void iniciarComponetes() {
		panelStartGame();
	}

	public PanelRecibirNombre getRecibir() {
		return recibir;
	}

	public JLabel getLabelNuevaPartida() {
		return nuevaPartida;
	}

	public JLabel getLabelCargarPartida() {
		return cargarPartida;
	}

	public JLabel getLabelSalir() {
		return labelSalir;
	}

	public JPanelInicioJuego getPanelJuego() {
		return panelJuego;
	}

	public void panelRecibirNombre() {
		recibir = new PanelRecibirNombre();
		recibir.setSize(1024, 662);
		recibir.setLocation(0, 0);
		panelContenedor.removeAll();
		panelContenedor.add(recibir, BorderLayout.CENTER);
		panelContenedor.revalidate();
		panelContenedor.repaint();
	}

	private void panelStartGame() {
		panelJuego = new JPanelInicioJuego();
		panelContenedor.setLayout(null);
		panelJuego.setBounds(0, 0, 1024, 662);
		panelJuego.setLayout(null);
		panelContenedor.add(panelJuego);
	}

	public void panel() {
		panel1 = new JPanel();
		getContentPane().setLayout(null);
		panel1.setBounds(0, 0, 1024, 662);
		panel1.setBackground(Color.WHITE);
		panel1.setLayout(null);
		panelContenedor.removeAll();
		panelContenedor.add(panel1, BorderLayout.CENTER);
		panelContenedor.revalidate();
		panelContenedor.repaint();

		LabelMenuPrincipal();
		labelNuevaPartida();
		labelCargaPartida();
		salir();
	}

	public void LabelMenuPrincipal() {
		menuPrincipal = new JLabel("MENÚ PRINCIPAL");
		menuPrincipal.setBackground(Color.LIGHT_GRAY);
		menuPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		menuPrincipal.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 31));
		menuPrincipal.setBounds(216, 54, 554, 53);
		panel1.add(menuPrincipal);
	}

	public void labelNuevaPartida() {
		nuevaPartida = new JLabel("1.- NUEVA PARTIDA");
		nuevaPartida.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		nuevaPartida.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nuevaPartida.setHorizontalAlignment(SwingConstants.CENTER);
		nuevaPartida.setForeground(Color.GRAY);
		nuevaPartida.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		nuevaPartida.setBounds(254, 142, 421, 32);
		panel1.add(nuevaPartida);
	}

	public void labelCargaPartida() {
		cargarPartida = new JLabel(" 2.-  CARGAR PARTIDA");
		cargarPartida.setBorder(new LineBorder(new Color(0, 0, 0)));
		cargarPartida.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cargarPartida.setForeground(Color.GRAY);
		cargarPartida.setHorizontalAlignment(SwingConstants.CENTER);
		cargarPartida.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		cargarPartida.setBounds(254, 214, 421, 32);
		panel1.add(cargarPartida);
	}

	public void salir() {
		labelSalir = new JLabel("3.- SALIR");
		labelSalir.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelSalir.setHorizontalAlignment(SwingConstants.CENTER);
		labelSalir.setForeground(Color.GRAY);
		labelSalir.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		labelSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelSalir.setBounds(254, 276, 295, 32);
		panel1.add(labelSalir);
	}

	public void mensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}

	public void addListenerJLabel(MouseListener listener) {
		nuevaPartida.addMouseListener(listener);
		cargarPartida.addMouseListener(listener);
		labelSalir.addMouseListener(listener);
	}
}
