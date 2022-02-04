package vista;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class JPanelInicioJuego extends JPanel {

    private JButton JLabelStart;
    private JLabel JLabelImagenFondo;

    public JPanelInicioJuego() {
        setFont(new Font("Showcard Gothic", Font.BOLD, 68));
        setBackground(new Color(0, 0, 51));
        setLayout(null);
        JLabelImagenFondo();
        JButtonStart();
    }

    public void JLabelImagenFondo() {
        JLabelImagenFondo = new JLabel("New label");
        ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("assets/fondos/StartFondo.jpg"));
        JLabelImagenFondo.setIcon(icon);
        JLabelImagenFondo.setBounds(0, 0, 1070, 696);
        add(JLabelImagenFondo);
    }

    public void JButtonStart() {
        JLabelStart = new JButton("START GAME");
        JLabelStart.setForeground(Color.BLACK);
        JLabelStart.setBackground(new Color(220, 220, 220));
        JLabelStart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JLabelStart.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        JLabelStart.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 41));
        JLabelStart.setBounds(218, 305, 566, 67);
        add(JLabelStart);
    }

    public JButton getJLabelStart() {
        return JLabelStart;
    }

    public void startGameButton(ActionListener listener) {
        JLabelStart.addActionListener(listener);
    }
}
