package vista;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseListener;

public class Vista extends JFrame {
    private JPanelInicioJuego panelJuego;
    private JPanel panelContenedor;
    private PanelRecibirNombre recibir;
    private JPanelContenedorCartas panelContenedorCartas;
    private JPaneMenuPrincipal panelMenuPrincipal;
    private String textoJTextField;

    public Vista() {
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

	public JPaneMenuPrincipal getPanelMenuPrincipal() {
		return panelMenuPrincipal;
	}

	public String getTextoJTextField() {
        return recibir.getRecibirNombreJugador().getText();
    }

    private void iniciarComponetes() {
        panelStartGame();
    }

    public PanelRecibirNombre getRecibir() {
        return recibir;
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

    public JPanelContenedorCartas getPanelContenedorCartas() {
		return panelContenedorCartas;
	}

	public void panelRecibirNombre() {
        recibir = new PanelRecibirNombre();
        recibir.setSize(1024, 662);
        recibir.setLocation(0, 0);
        panelContenedor.removeAll();
        panelContenedor.add(recibir, BorderLayout.CENTER);
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
