package vista;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelRecibirNombre extends JPanel {
    private JTextField _recibirNombreJugador;
    private JButton _botonRegistrar;

    public PanelRecibirNombre() {
        setBackground(new Color(0, 0, 128));
        setLayout(null);

        JButtonRegistrar();
        JTextFieldJugador();
        JLabelNombreJugador();
        JLabelImagenFondo();
    }

    public String getRecibirNombreJugador() {
        return (String) _recibirNombreJugador.getText();
    }

    public JButton getBotonRegistrar() {
        return _botonRegistrar;
    }

    private void JButtonRegistrar() {
        _botonRegistrar = new JButton("REGISTRAR");
        _botonRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _botonRegistrar.setForeground(new Color(0, 0, 0));
        _botonRegistrar.setBackground(new Color(255, 250, 205));
        _botonRegistrar.setFont(new Font("Showcard Gothic", Font.BOLD, 20));
        _botonRegistrar.setBounds(375, 435, 236, 42);
        add(_botonRegistrar);
    }

    private void JTextFieldJugador() {
        _recibirNombreJugador = new JTextField();
        _recibirNombreJugador.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
        _recibirNombreJugador.setBounds(277, 335, 447, 42);
        add(_recibirNombreJugador);
        _recibirNombreJugador.setColumns(10);
        PlaceHolder texto = new PlaceHolder("INGRESE SU NOMBRE DE JUGADOR...", _recibirNombreJugador);
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
        ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("assets/fondos/RecibirFondo.jpg"));
        imagenFondo.setIcon(icon);
        imagenFondo.setBackground(new Color(255, 250, 250));
        imagenFondo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        imagenFondo.setBounds(0, 13, 1024, 636);
        add(imagenFondo);
    }

    public void RegistraButton(ActionListener listener) {
        _botonRegistrar.addActionListener(listener);
    }

}