package controlador;

import modelo.Archivos;
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
	}

	public class listenerVistaJuego implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if (e.getSource() instanceof JLabel) {
				_listenerCartas = (JLabel) e.getSource();
				System.out.println("e.getSource is an instance of JLabelObject");

				if (_listenerCartas.getParent() == _vistaInicio.getPanelContenedorCartas().getJPanelMesa()) {
					System.out.println("hola");
				}

				else if (_listenerCartas.getParent() == _vistaInicio.getPanelContenedorCartas().getJLabelCartasJugador()) {
					String nada = (String) _listenerCartas.getText();
					System.out.println("este es el id: " + nada);
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