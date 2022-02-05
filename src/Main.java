import controlador.ControladorInicio;
import modelo.SemilleroCartas;
import vista.VistaInicio;

public class Main {

	public static void main(String[] args) {
		VistaInicio vistaJuegoInicio = new VistaInicio();
		SemilleroCartas semillero = new SemilleroCartas();

		ControladorInicio controladorJuegoInicio = new ControladorInicio(vistaJuegoInicio, semillero);
		vistaJuegoInicio.setVisible(true);
	}

}
