package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class JPanelInicioJuego extends JPanel {

	public JPanelInicioJuego() {
		setFont(new Font("Showcard Gothic", Font.BOLD, 68));
		setBackground(new Color(0, 0, 51));
		setLayout(null);
		
		JButton JLabelStart = new JButton("START GAME");
		JLabelStart.setForeground(Color.BLACK);
		JLabelStart.setBackground(new Color(220, 220, 220));
		JLabelStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("hi everyone");
			}
		});
		JLabelStart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JLabelStart.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JLabelStart.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 41));
		JLabelStart.setBounds(218, 305, 566, 67);
		add(JLabelStart);
		
		JLabel JLabelImagenFondo = new JLabel("New label");
		JLabelImagenFondo.setIcon(new ImageIcon(JPanelInicioJuego.class.getResource("/imagenes/casino.jpg")));
		JLabelImagenFondo.setBounds(0, 0, 1070, 696);
		add(JLabelImagenFondo);
		ImageIcon icon = new ImageIcon("imagenes/istockphoto-1158005632-612x612.jpg");
		
	}
}
