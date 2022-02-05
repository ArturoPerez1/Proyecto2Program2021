package modelo;

public class SemilleroCartas {
    private Cola cola;

    public SemilleroCartas() {
    	cola = new Cola();
    }

    public void generarMazoDeCartas() {	
    	cola.insertar(1, "♠", "assets/cartas/13p.png");
    	cola.insertar(2, "♠", "assets/cartas/13p.png");
    	cola.insertar(3, "♠", "assets/cartas/13p.png");
    	cola.insertar(4, "♠", "assets/cartas/13p.png");
    }
}
