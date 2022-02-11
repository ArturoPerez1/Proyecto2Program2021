package controlador;

import modelo.Carta;
import modelo.EstadoInicial;
import modelo.Mazo;
import vista.VistaInicio;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class ControladorMesaDeJuego {
	private Carta _recorrerMazos;
	private JLabel _listenerCartas;
	private VistaInicio _vistaInicio;
	private Mazo _listaCartasJugadorInterfaz;
	private Mazo _listaCartaMesaInterfaz;
	private int _ingresarDataJugador;

	/**
	 * @author Arturo Perez
	 *         <p>
	 *         Este constructor inicializa y llama a las funciones de la vista que
	 *         insertaran las caras obtenidas
	 */

	public ControladorMesaDeJuego(VistaInicio vistaMesaJuego, EstadoInicial gestorDeCartas) {
		int x = 20;
		int y = 50;
		int width = 82;
		int height = 101;
		int cont = 1;

		vistaMesaJuego.panelContenedorCartas();
		_recorrerMazos = gestorDeCartas.getMazoMesa().getMazo();
		_recorrerMazos = _recorrerMazos.getProximo();
		while (_recorrerMazos != null) {
			vistaMesaJuego.getPanelContenedorCartas().CartasMesa("assets/cartas/" + _recorrerMazos.getImagen(), x, y,
					width, height, _recorrerMazos.getIndiceCarta(), new listenerVistaJuego());
			_recorrerMazos = _recorrerMazos.getProximo();
			x += 125;
		}

		_recorrerMazos = gestorDeCartas.getMazoPersona().getJuego().getMazo();
		_recorrerMazos = _recorrerMazos.getProximo();
		x = 10;
		y = 10;
		while (_recorrerMazos != null) {
			vistaMesaJuego.getPanelContenedorCartas().CartasJugador("assets/cartas/" + _recorrerMazos.getImagen(), x, y,
					width, height, _recorrerMazos.getIndiceCarta(), new listenerVistaJuego());
			_recorrerMazos = _recorrerMazos.getProximo();
			x += 125;
		}

		x = 10;
		y = 10;
		while (cont <= 4) {
			vistaMesaJuego.getPanelContenedorCartas().CartasPc("assets/cartas/back.png", x, y, width, height);
			x += 125;
			cont++;
		}

		this._vistaInicio = vistaMesaJuego;
		_listaCartasJugadorInterfaz = new Mazo();
		_listaCartaMesaInterfaz = new Mazo();
		_ingresarDataJugador = 1;
	}

	public class listenerVistaJuego implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if (e.getSource() instanceof JLabel) {
				_listenerCartas = (JLabel) e.getSource();

				if (_listenerCartas.getParent() == _vistaInicio.getPanelContenedorCartas().getJPanelMesa()) {
					String idCartaMesaInstance = (String) _listenerCartas.getText();
					_listaCartaMesaInterfaz.InsertarId(idCartaMesaInstance);

					Carta listaAux = _listaCartaMesaInterfaz.getListaCartasInterfaz();
					listaAux = listaAux.getProximo();

					while (listaAux != null) {
						System.out.println("id = " + listaAux.getIndiceCarta());
						listaAux = listaAux.getProximo();
					}
				}

				else if (_listenerCartas.getParent() == _vistaInicio.getPanelContenedorCartas()
						.getJLabelCartasJugador()) {
					String idCartaJugadorInstance = (String) _listenerCartas.getText();
					if (_ingresarDataJugador == 1) {
						_listaCartasJugadorInterfaz.InsertarId(idCartaJugadorInstance);
						_ingresarDataJugador++;
					}
				}

			}
		}

		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}
}