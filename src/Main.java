import controlador.ControladorInicio;
import modelo.SemilleroCartas;
import vista.VistaInicio;

public class Main {

    public static void main(String[] args) {
        VistaInicio vistaJuegoInicio = new VistaInicio();
        SemilleroCartas semilleroCartas = new SemilleroCartas();

        ControladorInicio controladorJuegoInicio = new ControladorInicio(vistaJuegoInicio, semilleroCartas);
        vistaJuegoInicio.setVisible(true);
    }

}
