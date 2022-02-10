import controlador.ControladorInicio;
import modelo.Partida;
import vista.VistaInicio;

public class Main {

    public static void main(String[] args) {
        VistaInicio vistaJuegoInicio = new VistaInicio();
        Partida partida = new Partida();

        ControladorInicio controladorJuegoInicio = new ControladorInicio(vistaJuegoInicio, partida);
        vistaJuegoInicio.setVisible(true);
    }

}