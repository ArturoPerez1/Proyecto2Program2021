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
	private boolean _tomarCarta;
	private EstadoInicial _gestorDeCartas;

	public Mazo get_listaCartasJugadorInterfaz() {
		return _listaCartasJugadorInterfaz;
	}

	public Mazo get_listaCartaMesaInterfaz() {
		return _listaCartaMesaInterfaz;
	}

	/**
	 * @author Arturo Perez
	 *         <p>
	 *         Este constructor inicializa y llama a las funciones de la vista que
	 *         insertaran las caras obtenidas
	 */

	public ControladorMesaDeJuego(VistaInicio vistaMesaJuego, EstadoInicial gestorDeCartas) {
		this._gestorDeCartas = gestorDeCartas;
		this._vistaInicio = vistaMesaJuego;
		this._listaCartasJugadorInterfaz = new Mazo();
		this._listaCartaMesaInterfaz = new Mazo();
		this._ingresarDataJugador = 1;
		this._tomarCarta = false;
		vistaMesaJuego.panelContenedorCartas();

		iniciarComponentes();
	}

	public void iniciarComponentes() {
		int x = 20;
		int y = 50;
		int width = 82;
		int height = 101;
		int cont = 1;

		_recorrerMazos = _gestorDeCartas.getMazoMesa().getMazo();
		_recorrerMazos = _recorrerMazos.getProximo();
		while (_recorrerMazos != null) {
			_vistaInicio.getPanelContenedorCartas().CartasMesa("assets/cartas/" + _recorrerMazos.getImagen(), x, y,
					width, height, _recorrerMazos.getIndiceCarta(), new listenerVistaJuego());
			_recorrerMazos = _recorrerMazos.getProximo();
			x += 125;
		}

		_recorrerMazos = _gestorDeCartas.getMazoPersona().getJuego().getMazo();
		_recorrerMazos = _recorrerMazos.getProximo();
		x = 10;
		y = 10;
		while (_recorrerMazos != null) {
			_vistaInicio.getPanelContenedorCartas().CartasJugador("assets/cartas/" + _recorrerMazos.getImagen(), x, y,
					width, height, _recorrerMazos.getIndiceCarta(), new listenerVistaJuego());
			_recorrerMazos = _recorrerMazos.getProximo();
			x += 125;
		}

		x = 10;
		y = 10;
		while (cont <= 4) {
			_vistaInicio.getPanelContenedorCartas().CartasPc("assets/cartas/back.png", x, y, width, height);
			x += 125;
			cont++;
		}

	}

	public class listenerVistaJuego implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if (e.getSource() instanceof JLabel) {
				_listenerCartas = (JLabel) e.getSource();

				if (_listenerCartas.getParent() == _vistaInicio.getPanelContenedorCartas().getJPanelMesa()) {
					System.out.println("entre1");
					String idCartaMesaInstance = (String) _listenerCartas.getText();
					_listaCartaMesaInterfaz.InsertarId(idCartaMesaInstance);
					_tomarCarta = true;
				}

				else if (_listenerCartas.getParent() == _vistaInicio.getPanelContenedorCartas()
						.getJLabelCartasJugador()) {
					if (_tomarCarta) {
						String idCartaJugadorInstance = (String) _listenerCartas.getText();
						if (_ingresarDataJugador == 1) {
							System.out.println("entre");
							_listaCartasJugadorInterfaz.InsertarId(idCartaJugadorInstance);
							_listaCartasJugadorInterfaz.VerificarSumaCartas(_listaCartaMesaInterfaz,
									_listaCartasJugadorInterfaz, _gestorDeCartas.getMazoMesa().getMazo(),
									_gestorDeCartas.getMazoPersona().getJuego().getMazo());
							
							Carta listaAux = _listaCartasJugadorInterfaz.getMazo().getProximo();
							while(listaAux != null) {
								System.out.println("Estas son las Cartas no sumadas: " + listaAux.getValor());
								listaAux = listaAux.getProximo();
							}
							_ingresarDataJugador++;
						}
					} else {
						_vistaInicio.mensaje("SELECCIONE UNA CARTA DE LA MESA PRIMERO");
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