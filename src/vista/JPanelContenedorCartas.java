package vista;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.MouseListener;

public class JPanelContenedorCartas extends JPanel {
    private JPanel JPanelMesa;
    private JLabel JLabelMesaJuego;
    private JPanel JPanelPc;
    private JLabel JLabelCartasPc;
    private JPanel JPanelJugador;
    private JLabel JLabelCartasJugador;
    private JLabel JLabelMaderaFondo;
    private JLabel _carta;

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
      
    public void CartasJugador(String imagen, int x, int y, int witdh, int height) {
    	JLabel carta = new JLabel();
    	carta.setBounds(x, y, witdh, height);
    	ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(imagen).getScaledInstance(witdh, height, Image.SCALE_SMOOTH));
    	carta.setIcon(icon);
    }

    private void JPanelMesa() {
        JPanelMesa = new JPanel();
        JPanelMesa.setBounds(177, 154, 614, 350);
        add(JPanelMesa);
        JPanelMesa.setLayout(null);
    }
    
    public void CartasMesa(String imagen, int x, int y, int witdh, int height, MouseListener mouseListener) {
    	_carta = new JLabel();
    	_carta.setBounds(x, y, witdh, height);
    	ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(imagen).getScaledInstance(witdh, height, Image.SCALE_SMOOTH));
    	_carta.setIcon(icon);
    	JPanelMesa.add(_carta);
    	_carta.addMouseListener(mouseListener);
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
    
	public JLabel get_carta() {
		return _carta;
	}
}
