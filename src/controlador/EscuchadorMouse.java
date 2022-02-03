package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import controlador.Controlador.listenerVistaJuego;
import modelo.Modelo;
import modelo.Partida;
import vista.Vista;

public class EscuchadorMouse {
	 private Vista _vistaJuego = new Vista();
	    private Modelo _modeloJuego = new Modelo();

	    public EscuchadorMouse(Vista vistaJuego, Modelo modeloJuego) {
	        this._vistaJuego = vistaJuego;
	        this._modeloJuego = modeloJuego;

		_vistaJuego.addListenerJLabel(new listenerMouseEvent());
	    }

	    public class listenerMouseEvent implements MouseListener {
        	public void mouseClicked(MouseEvent e) {
        		if(e.getSource() == _vistaJuego.getLabelNuevaPartida()) {
					Partida juego = new Partida();
					juego.partidaNueva();
        		}
        		
        		else if(e.getSource() == _vistaJuego.getLabelCargarPartida()) {
					_vistaJuego.mensaje("hola");
        		}
        		
        		else if(e.getSource() == _vistaJuego.getLabelSalir()) {
        			System.exit(0);
        		}
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
