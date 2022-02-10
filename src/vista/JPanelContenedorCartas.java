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
        _jPanelMesa = new JPanel();
        _jPanelMesa.setBounds(177, 154, 614, 350);
        add(_jPanelMesa);
        _jPanelMesa.setLayout(null);
    }

    public void CartasMesa(String imagen, int x, int y, int witdh, int height, MouseListener mouseListener) {
        _carta = new JLabel();
        _carta.setBounds(x, y, witdh, height);
        ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(imagen).getScaledInstance(witdh, height, Image.SCALE_SMOOTH));
        _carta.setIcon(icon);
        _jPanelMesa.add(_carta);
        _carta.addMouseListener(mouseListener);
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

    private void JPanelJugador() {
        _jPanelJugador = new JPanel();
        _jPanelJugador.setBackground(new Color(255, 255, 255));
        _jPanelJugador.setBounds(177, 521, 614, 141);
        add(_jPanelJugador);
        _jPanelJugador.setLayout(null);
    }

    private void JLabelCartasJugador() {
        _jLabelCartasJugador = new JLabel("New label");
        ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("assets/fondos/PanelCartas.jpg"));
        _jLabelCartasJugador.setIcon(icon);
        _jLabelCartasJugador.setBounds(0, 0, 614, 141);
        _jPanelJugador.add(_jLabelCartasJugador);

    }

    private void JLabelMaderaFondo() {
        _jLabelMaderaFondo = new JLabel("New label");
        ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("assets/fondos/StartFondo.jpg"));
        _jLabelMaderaFondo.setIcon(icon);
        _jLabelMaderaFondo.setBounds(0, 0, 1024, 662);
        add(_jLabelMaderaFondo);
    }

    public JLabel get_carta() {
        return _carta;
    }
}