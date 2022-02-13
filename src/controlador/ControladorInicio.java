package controlador;

import modelo.Archivos;
import modelo.Carta;
import modelo.EstadoInicial;
import modelo.Partida;
import vista.VistaInicio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorInicio {
	private ControladorMesaDeJuego _controladorMesaDeJuego;
	private VistaInicio _vistaJuegoInicio;
	private Archivos _archivosControl;
	private EstadoInicial _controladorCartas;
	private Partida _partida;

	public ControladorInicio() {

	}

	public ControladorInicio(VistaInicio vistaJuego, Partida partida) {
		this._archivosControl = new Archivos();
		this._vistaJuegoInicio = vistaJuego;
		this._partida = partida;

		_vistaJuegoInicio.getPanelJuego().startGameButton(new listenerVistaJuego());
	}

	public class listenerVistaJuego implements ActionListener {
		public void actionPerformed(ActionEvent eventoVistaJuegoInicio) {

			try {
				if (eventoVistaJuegoInicio.getSource() == _vistaJuegoInicio.getPanelJuego().getJLabelStart()) {
					_vistaJuegoInicio.panelRecibirNombre();
					_vistaJuegoInicio.getRecibir().RegistraButton(new listenerVistaJuego());
				} else if (eventoVistaJuegoInicio.getSource() == _vistaJuegoInicio.getRecibir().getBotonRegistrar()) {
					_vistaJuegoInicio.panelMenuPrincipal();
					_vistaJuegoInicio.getPanelMenuPrincipal().addActionLister1(new listenerVistaJuego());
					_archivosControl.GuardarNombre(_vistaJuegoInicio.getTextoJTextField());
				} else if (eventoVistaJuegoInicio.getSource() == _vistaJuegoInicio.getPanelMenuPrincipal().getJButtonEmpezar()) {
					_partida.partidaNueva(_vistaJuegoInicio.getTextoJTextField());
					_partida.TurnosYPartidaCompleta();
					_controladorMesaDeJuego = new ControladorMesaDeJuego(_vistaJuegoInicio, _partida.getGestionInicialJuego(), _partida);
				} else if (eventoVistaJuegoInicio.getSource() == _vistaJuegoInicio.getPanelMenuPrincipal().getJButtonCargar()) {
					_vistaJuegoInicio.mensaje("hola man1");
				} else if (eventoVistaJuegoInicio.getSource() == _vistaJuegoInicio.getPanelMenuPrincipal().getJButtonSalir()) {
					System.exit(0);
				}

			} catch (Error e) {
				System.out.println("Error" + e);
			}
		}
	}
}