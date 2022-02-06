package modelo;

public class Cola {
    private Carta _inicioCola, _finalCola;
    private String _colaTexto = " ";

    public Cola() {
        _inicioCola = null;
        _finalCola = null;
    }

    public Carta getInicioCola() {
        return _inicioCola;
    }

    public Carta getFinalCola() {
        return _finalCola;
    }

    public String getColaTexto() {
        return _colaTexto;
    }

    public boolean colaVacia() {
        return _inicioCola == null;
    }

    public void insertar(int id, String figura, String valor, String imagen) {
        Carta nuevaCarta = new Carta();

        nuevaCarta.setIndiceCarta(id);
        nuevaCarta.setFigura(figura);
        nuevaCarta.setNumero(valor);
        nuevaCarta.setImagen(imagen);
        nuevaCarta.setProximo(null);

        if (colaVacia()) {
            _inicioCola = nuevaCarta;
            _finalCola = nuevaCarta;
        } else {
            _finalCola.setProximo(nuevaCarta);
            _finalCola = nuevaCarta;
        }
    }

    public void mostrarContenido() {
        Carta recorrido = _inicioCola;

        while (recorrido != null) {
            _colaTexto += recorrido.getIndiceCarta() + recorrido.getFigura() + recorrido.getValor() + " ->";
            recorrido = recorrido.getProximo();
        }
        _colaTexto += " null";
        System.out.println(_colaTexto);
    }
}
