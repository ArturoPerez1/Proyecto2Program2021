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
import java.awt.event.MouseEvent;
import java.awt.peer.LabelPeer;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;

public class Vista extends JFrame {
    private JPanel _panel = new JPanel();
    private JLabel labelNuevaPartida;
    private JLabel labelCargarPartida;
    private JLabel labelSalir;
    
    public JLabel getLabelNuevaPartida() {
		return labelNuevaPartida;
	}

	public JLabel getLabelCargarPartida() {
		return labelCargarPartida;
	}

	public JLabel getLabelSalir() {
		return labelSalir;
	}

	public Vista() {
        setSize(1000, 801);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.GRAY);
        setTitle("Ventana Principal");
        panel();
    }

    private void panel() {
        this.getContentPane().add(_panel);
        _panel.setBackground(Color.WHITE);
        _panel.setLayout(null);
        
        JLabel labelMenuPrincipal = new JLabel("MENÚ PRINCIPAL");
        labelMenuPrincipal.setBackground(Color.LIGHT_GRAY);
        labelMenuPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
        labelMenuPrincipal.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 31));
        labelMenuPrincipal.setBounds(216, 54, 554, 53);
        _panel.add(labelMenuPrincipal);
        
        labelNuevaPartida = new JLabel("1.- NUEVA PARTIDA");
        labelNuevaPartida.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        labelNuevaPartida.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        labelNuevaPartida.setHorizontalAlignment(SwingConstants.CENTER);
        labelNuevaPartida.setForeground(Color.GRAY);
        labelNuevaPartida.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        labelNuevaPartida.setBounds(254, 142, 421, 32);
        _panel.add(labelNuevaPartida);
        
        labelCargarPartida = new JLabel(" 2.-  CARGAR PARTIDA");
        labelCargarPartida.setBorder(new LineBorder(new Color(0, 0, 0)));
        labelCargarPartida.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        labelCargarPartida.setForeground(Color.GRAY);
        labelCargarPartida.setHorizontalAlignment(SwingConstants.CENTER);
        labelCargarPartida.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        labelCargarPartida.setBounds(254, 214, 421, 32);
        _panel.add(labelCargarPartida);
        
        labelSalir = new JLabel("3.- SALIR");
        labelSalir.setBorder(new LineBorder(new Color(0, 0, 0)));
        labelSalir.setHorizontalAlignment(SwingConstants.CENTER);
        labelSalir.setForeground(Color.GRAY);
        labelSalir.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        labelSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        labelSalir.setBounds(254, 276, 295, 32);
        _panel.add(labelSalir);
    }
    
    public void mensaje(String mensaje) {
    	JOptionPane.showMessageDialog(this, "Hola");
    }

    public void addListenerJLabel(java.awt.event.MouseListener listener) {
    	labelNuevaPartida.addMouseListener(listener);
    	labelCargarPartida.addMouseListener(listener);
    	labelSalir.addMouseListener(listener);
    	
    }
}
