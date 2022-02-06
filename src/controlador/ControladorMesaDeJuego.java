package controlador;

import vista.VistaInicio;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorMesaDeJuego {
    public ControladorMesaDeJuego(VistaInicio vistaMesaJuego) {
        vistaMesaJuego.panelContenedorCartas();
        vistaMesaJuego.getPanelContenedorCartas().CartasMesa("assets/cartas/13p.png", 100, 50, 82, 101, new listenerVistaJuego());
        vistaMesaJuego.getPanelContenedorCartas().CartasMesa("assets/cartas/12p.png", 190, 50, 82, 101, new listenerVistaJuego());
    }

    public class listenerVistaJuego implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent arg0) {

        }

        @Override
        public void mouseEntered(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseExited(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mousePressed(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
            // TODO Auto-generated method stub

        }

    }
}
