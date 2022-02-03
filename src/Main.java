import controlador.Controlador;
import controlador.EscuchadorMouse;
import modelo.Modelo;
import vista.Vista;

public class Main {

	public static void main(String[] args) {
		Vista vistaJuego = new Vista();
		Modelo modeloJuego = new Modelo();

		Controlador controlador = new Controlador(vistaJuego, modeloJuego);
		vistaJuego.setVisible(true);
	}

}
