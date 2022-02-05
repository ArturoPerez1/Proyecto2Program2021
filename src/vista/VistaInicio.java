package vista;

import javax.swing.*;
import java.awt.*;

public class VistaInicio extends JFrame {
    private JPanelInicioJuego panelJuego;
    private JPanel panelContenedor;
    private PanelRecibirNombre _panelRecibirNombre;
    private JPanelContenedorCartas panelContenedorCartas;
    private JPaneMenuPrincipal panelMenuPrincipal;
    private String textoJTextField;

    public VistaInicio() {
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

    public JPanelContenedorCartas getPanelContenedorCartas() {
        return panelContenedorCartas;
    }

    public JPaneMenuPrincipal getPanelMenuPrincipal() {
        return panelMenuPrincipal;
    }

    public String getTextoJTextField() {
        return _panelRecibirNombre.getRecibirNombreJugador();
    }

    private void iniciarComponetes() {
        panelStartGame();
    }

    public PanelRecibirNombre getRecibir() {
        return _panelRecibirNombre;
    }

    public JPanelInicioJuego getPanelJuego() {
        return panelJuego;
    }

    public void panelContenedorCartas() {
        panelContenedorCartas = new JPanelContenedorCartas();
        panelContenedorCartas.setSize(1024, 662);
        panelContenedorCartas.setLocation(0, 0);
        panelContenedor.removeAll();
        panelContenedor.add(panelContenedorCartas, BorderLayout.CENTER);
        panelContenedor.revalidate();
        panelContenedor.repaint();
    }

    public void panelMenuPrincipal() {
        panelMenuPrincipal = new JPaneMenuPrincipal();
        panelMenuPrincipal.setSize(1024, 662);
        panelMenuPrincipal.setLocation(0, 0);
        panelContenedor.removeAll();
        panelContenedor.add(panelMenuPrincipal, BorderLayout.CENTER);
        panelContenedor.revalidate();
        panelContenedor.repaint();
    }

    public void panelRecibirNombre() {
        _panelRecibirNombre = new PanelRecibirNombre();
        _panelRecibirNombre.setSize(1024, 662);
        _panelRecibirNombre.setLocation(0, 0);
        panelContenedor.removeAll();
        panelContenedor.add(_panelRecibirNombre, BorderLayout.CENTER);
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

    public void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

}
