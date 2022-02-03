package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.ControladorDeArchivos;
import modelo.Modelo;
import vista.Vista;

public class Controlador {
	private Vista _vistaJuego = new Vista();
	private Modelo _modeloJuego = new Modelo();
	private ControladorDeArchivos archivosControl;

	public Controlador(Vista vistaJuego, Modelo modeloJuego) {
		this._vistaJuego = vistaJuego;
		this._modeloJuego = modeloJuego;

		_vistaJuego.getPanelJuego().startGameButton(new listenerVistaJuego());
	}

	public class listenerVistaJuego implements ActionListener {
		public void actionPerformed(ActionEvent eventoVistaJuego) {

			try {
				if (eventoVistaJuego.getSource() == _vistaJuego.getPanelJuego().getJLabelStart()) {
					_vistaJuego.panelRecibirNombre();
					_vistaJuego.getRecibir().RegistraButton(new listenerVistaJuego());
				}

				else if (eventoVistaJuego.getSource() == _vistaJuego.getRecibir().getBotonRegistrar()) {
					archivosControl = new ControladorDeArchivos(_vistaJuego);
					archivosControl.RegistrarNombreJugador();
				}

			} catch (Error e) {

			}
		}
	}
}
