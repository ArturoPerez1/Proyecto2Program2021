package vista;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Vista extends JFrame {
    private JPanel _panel = new JPanel();

    public Vista() {
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.GRAY);
        setTitle("Ventana Principal");
        panel();
    }

    private void panel() {
        this.getContentPane().add(_panel);
        _panel.setBackground(new Color(166, 247, 215));
        _panel.setLayout(null);
    }

    public void listenerAction(ActionListener action) {

    }
}
