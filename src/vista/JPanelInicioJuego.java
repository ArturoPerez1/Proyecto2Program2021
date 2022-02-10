package vista;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPanelInicioJuego extends JPanel {

    private JButton _jLabelStart;
    private JLabel _jLabelImagenFondo;

    public JPanelInicioJuego() {
        setFont(new Font("Showcard Gothic", Font.BOLD, 68));
        setBackground(new Color(0, 0, 51));
        setLayout(null);
        JLabelImagenFondo();
        JButtonStart();
    }

    public void JLabelImagenFondo() {
        _jLabelImagenFondo = new JLabel("New label");
        ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("assets/fondos/StartFondo.jpg"));
        _jLabelImagenFondo.setIcon(icon);
        _jLabelImagenFondo.setBounds(0, 0, 1070, 696);
        add(_jLabelImagenFondo);
    }

    public void JButtonStart() {
        _jLabelStart = new JButton("START GAME");
        _jLabelStart.setForeground(Color.BLACK);
        _jLabelStart.setBackground(new Color(220, 220, 220));
        _jLabelStart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _jLabelStart.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        _jLabelStart.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 41));
        _jLabelStart.setBounds(218, 305, 566, 67);
        add(_jLabelStart);
    }

    public JButton getJLabelStart() {
        return _jLabelStart;
    }

    public void startGameButton(ActionListener listener) {
        _jLabelStart.addActionListener(listener);
    }
}