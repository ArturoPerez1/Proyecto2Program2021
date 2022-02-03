package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

import vista.TextPrompt;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.JSeparator;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelRecibirNombre extends JPanel {
	private JTextField recibirNombreJugador;
	private JButton botonRegistrar;

	public PanelRecibirNombre() {
		setBackground(new Color(0, 0, 128));
		setLayout(null);

		JButtonRegistrar();
		JTextFieldJugador();
		JLabelNombreJugador();
		JLabelImagenFondo();
	}

	public JTextField getRecibirNombreJugador() {
		return recibirNombreJugador;
	}

	public JButton getBotonRegistrar() {
		return botonRegistrar;
	}

	private void JButtonRegistrar() {
		botonRegistrar = new JButton("REGISTRAR");
		botonRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonRegistrar.setForeground(new Color(0, 0, 0));
		botonRegistrar.setBackground(new Color(255, 250, 205));
		botonRegistrar.setFont(new Font("Showcard Gothic", Font.BOLD, 20));
		botonRegistrar.setBounds(375, 435, 236, 42);
		add(botonRegistrar);
	}

	private void JTextFieldJugador() {
		recibirNombreJugador = new JTextField();
		recibirNombreJugador.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
		recibirNombreJugador.setBounds(277, 335, 447, 42);
		add(recibirNombreJugador);
		recibirNombreJugador.setColumns(10);
		TextPrompt texto = new TextPrompt("INGRESE SU NOMBRE DE JUGADOR...", recibirNombreJugador);
		texto.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
	}

	private void JLabelNombreJugador() {
		JPanel panelNombreJugador = new JPanel();
		panelNombreJugador.setBackground(new Color(255, 250, 205));
		panelNombreJugador.setBounds(176, 203, 662, 66);
		add(panelNombreJugador);

		JLabel nombreJugador = new JLabel("NOMBRE DE JUGADOR");
		panelNombreJugador.add(nombreJugador);
		nombreJugador.setHorizontalAlignment(SwingConstants.CENTER);
		nombreJugador.setForeground(new Color(0, 0, 0));
		nombreJugador.setFont(new Font("Showcard Gothic", Font.BOLD, 44));
	}

	private void JLabelImagenFondo() {
		JLabel imagenFondo = new JLabel("New label");
		imagenFondo.setBackground(new Color(255, 250, 250));
		imagenFondo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		imagenFondo.setIcon(new ImageIcon(PanelRecibirNombre.class
				.getResource("/imagenes/Interior-del-Rio-Casino-Resort-en-Klerksdorp-1024x640.jpg")));
		imagenFondo.setBounds(0, 13, 1024, 636);
		add(imagenFondo);
	}

	public void RegistraButton(ActionListener listener) {
		botonRegistrar.addActionListener(listener);
	}

}
