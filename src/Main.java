import controlador.Controlador;
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
