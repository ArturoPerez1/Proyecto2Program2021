package modelo;

public class Carta {

    // Atributos
    private String _figura, _valor, _imagen;
    private int _indiceCarta;
    private Carta _proximo;

    // Constructor
    public Carta() {
        this._indiceCarta = 0;
        this._figura = "";
        this._valor = "";
        this._proximo = null;
    }

    public Carta(int indiceCarta, String figura, String valor, String imagen, Carta n) {
        this._indiceCarta = indiceCarta;
        this._imagen = imagen;
        this._figura = figura;
        this._valor = valor;
        this._proximo = n;
    }

    public String getFigura() {
        return _figura;
    }

    public void setFigura(String tipo) {
        this._figura = tipo;
    }

    public String getValor() {
        return _valor;
    }

    public void setNumero(String valor) {
        this._valor = valor;
    }

    public String getImagen() {
        return _imagen;
    }

    public void setImagen(String imagen) {
        this._imagen = imagen;
    }

    public int getIndiceCarta() {
        return _indiceCarta;
    }

    public void setIndiceCarta(int indiceCarta) {
        this._indiceCarta = indiceCarta;
    }

    public Carta getProximo() {
        return _proximo;
    }

    public void setProximo(Carta proximo) {
        this._proximo = proximo;
    }
}