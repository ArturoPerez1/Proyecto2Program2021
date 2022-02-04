package modelo;

public class Carta {

    // Atributos
    private String tipo, numero;
    private int indiceCarta;
    private Carta proximo;

    // Constructor
    public Carta() {
        this.tipo = " ";
        this.numero = " ";
        this.indiceCarta = 0;
        this.proximo = null;
    }

    public Carta(String tipo, String numero, int indiceCarta, Carta n) {
        this.tipo = tipo;
        this.numero = numero;
        this.indiceCarta = indiceCarta;
        this.proximo = n;
    }

    // Metodos Getters y Setters

    // get
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    // set
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Carta getProximo() {
        return proximo;
    }

    public void setProximo(Carta proximo) {
        this.proximo = proximo;
    }

    public int getIndiceCarta() {
        return indiceCarta;
    }

    public void setIndiceCarta(int indiceCarta) {
        this.indiceCarta = indiceCarta;
    }
}