package modelo;

public class Mazo {
    private Carta _mazo, _inicioCola, _finalCola;
    private int _cantidadCartas;

    public Mazo() {
        _mazo = null;
        _cantidadCartas = 0;
    }

    public Carta getMazo() {
        return _mazo;
    }

    public void setMazo(Carta mazo) {
        this._mazo = mazo;
    }

    public int getCantidadCartas() {
        return _cantidadCartas;
    }

    public void setCantidadCartas(int cantidadCartas) {
        this._cantidadCartas = cantidadCartas;
    }

    // Insertar las Cartas
    public void InsertarCarta(int id, String figura, String valor, String imagen) {
        Carta auxiliar = new Carta();
        Carta auxiliar2 = new Carta();

        auxiliar.setIndiceCarta(id);
        auxiliar.setFigura(figura);
        auxiliar.setNumero(valor);
        auxiliar.setImagen(imagen);
        auxiliar.setProximo(null);

        if (_mazo == null) {
            _mazo = auxiliar;
        } else {
            auxiliar2 = _mazo;
            while (auxiliar2.getProximo() != null) {
                auxiliar2 = auxiliar2.getProximo();
            }
            auxiliar2.setProximo(auxiliar);
        }
    }

    public void EliminarCarta(String tipo, String numero) {
        if (_mazo == null) System.out.println("lista vacía");
        else if (_mazo.getFigura().equals(tipo) && _mazo.getValor().equals(numero)) {
            _mazo = _mazo.getProximo();
        } else {
            Carta actual = _mazo;
            while (actual.getProximo() != null && actual.getProximo().getFigura() != tipo && actual.getProximo().getValor() != numero)
                actual = actual.getProximo();
            if (actual.getProximo() == null)
                System.out.println("elemento " + actual.getFigura() + actual.getValor() + " no esta en la lista");
            else {
                actual.setProximo(actual.getProximo().getProximo());
            }
        }
    }

    // Llenar el Numero de las Cartas
    public void CartasMazo(String tipo, String numero, int indiceCarta) {

        numero = "AS";
        InsertarCarta(indiceCarta, tipo, numero, "");

        for (int i = 2; i <= 10; i++) {
            numero = String.valueOf(i);
            indiceCarta++;
            InsertarCarta(indiceCarta, tipo, numero, "");
        }

        numero = "J";
        indiceCarta++;
        InsertarCarta(indiceCarta, tipo, numero, "");
        numero = "Q";
        indiceCarta++;
        InsertarCarta(indiceCarta, tipo, numero, "");
        numero = "K";
        indiceCarta++;
        InsertarCarta(indiceCarta, tipo, numero, "");
    }

    // Llenar el Tipo de Carta
    public void LlenarMazo() {
        int indiceCarta = 1;
        String tipo = " ", numero = " ";
        String imagen = " ";

        tipo = "♣";// Treboles
        CartasMazo(tipo, numero, indiceCarta);

        tipo = "♥";// Corazones Rojos
        indiceCarta = 14;
        CartasMazo(tipo, numero, indiceCarta);

        tipo = "♠";// Corazones Negros
        indiceCarta = 27;
        CartasMazo(tipo, numero, indiceCarta);

        tipo = "♦";// Diamantes Rojos
        indiceCarta = 40;
        CartasMazo(tipo, numero, indiceCarta);
    }

    // Imprimir Cartas del Juego
    public void ImprimirMazo() {
        if (_mazo != null) {
            int contar = 0;
            Carta auxiliar = _mazo;

            while (auxiliar != null) {
                System.out.print(auxiliar.getFigura() + auxiliar.getValor());
                if ((auxiliar.getFigura() + auxiliar.getValor()).length() > 2) System.out.print(" ");
                else System.out.print("  ");
                if (contar == 4) {
                    System.out.println();
                    contar = 0;
                } else contar++;
                auxiliar = auxiliar.getProximo();
            }

        } else System.out.print("El mazo esta vacio");
        System.out.println();
    }

    public void ImprimirMazoConIndice() {
        int opciones = 1;
        Carta actual = _mazo;

        if (actual != null) {
            while (actual != null) {
                System.out.println(opciones + ". " + actual.getFigura() + " " + actual.getValor());
                actual = actual.getProximo();
                opciones++;
            }
            System.out.println();
        } else {
            System.out.println("El mazo esta vacio");
        }
    }

    public boolean esVacia() {
        boolean log = false;
        if (_mazo == null) log = true;
        return log;
    }

    public int RecorerMazo(Carta recorrer) {
        Carta auxiliar = recorrer;
        int contador = 0;

        while (auxiliar != null) {
            contador++;
            auxiliar = auxiliar.getProximo();
        }
        return contador;
    }

    public boolean buscarRepetidosCadenas(String valor) {
        Carta buscar = new Carta();
        buscar = _mazo;

        if (esVacia()) return true;
        while (buscar != null) {
            if (buscar.getValor() == valor) {
                return false;
            } else {
                buscar = buscar.getProximo();
            }
        }
        return true;
    }

    public boolean buscarRepetidos(Mazo mazo, int valor) {
        Carta buscar = new Carta();
        buscar = mazo._mazo;

        if (esVacia()) return true;
        while (buscar != null) {
            if (buscar.getIndiceCarta() == valor) {
                return false;
            } else {
                buscar = buscar.getProximo();
            }
        }
        return true;
    }

    public Carta baraja() {
        int valor;
        Mazo lista = new Mazo();

        do {
            valor = (int) (1 + Math.random() * 52);
            if (buscarRepetidos(lista, valor)) lista.InsertarCarta(valor, " ", "", "");
        } while (RecorerMazo(lista._mazo) != 52);

        return lista._mazo;
    }

    public void barajearMazo() {
        Mazo mazoBarajeado = new Mazo();
        Carta lista = new Carta();
        Carta actual = new Carta();
        lista = baraja();
        actual = _mazo.getProximo();

        while (lista != null) {
            if (lista.getIndiceCarta() == actual.getIndiceCarta()) {
                Carta nuevaCarta = new Carta(actual.getIndiceCarta(), actual.getFigura(), actual.getValor(), null);
                mazoBarajeado.InsertarCarta(nuevaCarta.getIndiceCarta(), nuevaCarta.getFigura(), nuevaCarta.getValor(), "");
                lista = lista.getProximo();
                actual = _mazo;
            } else {
                actual = actual.getProximo();
            }
        }

        _mazo = mazoBarajeado._mazo;
    }

    public Carta sacarCartaPorValor(String valor) {
        Carta recorerMazo = new Carta();
        Carta buscarCorNegros = new Carta();
        recorerMazo = _mazo;

        while (recorerMazo != null) {
            if (recorerMazo.getValor() == valor) {
                if ((buscarRepetidosCadenas(valor)) && (recorerMazo.getIndiceCarta() < 27) && (recorerMazo.getIndiceCarta() > 39)) {
                    buscarCorNegros = recorerMazo.getProximo();
                    while (buscarCorNegros != null) {
                        if ((buscarCorNegros.getValor() == valor) && ((buscarCorNegros.getIndiceCarta() > 26) && (buscarCorNegros.getIndiceCarta() < 40)))
                            return buscarCorNegros;
                        buscarCorNegros = buscarCorNegros.getProximo();
                    }
                }
                return recorerMazo;
            }
            recorerMazo = recorerMazo.getProximo();
        }
        return recorerMazo;
    }

    public Carta sacarCartaPorValor2(String valor) {
        Carta recorerMazo = new Carta();
        recorerMazo = _mazo;

        while (recorerMazo != null) {
            if (recorerMazo.getValor().equals(valor)) {
                return recorerMazo;
            }
            recorerMazo = recorerMazo.getProximo();
        }
        return recorerMazo;
    }

    public Carta sacarCartaMazo(int posicion) {
        Carta recorerMazo = new Carta();
        recorerMazo = _mazo;

        for (int i = 1; i < posicion; i++) {
            recorerMazo = recorerMazo.getProximo();
        }
        return recorerMazo;
    }

    public void RepartirCartas(boolean reparteMesa, boolean reparte, Mazo mazoJugador, Mazo mazoComputadora, Mazo mazoMesa) {
        Carta aux = new Carta();
        int repartir = 1;
        aux = _mazo;

        if (aux != null) {
            if (reparte) {
                while (repartir <= 4) {
                    mazoComputadora.InsertarCarta(aux.getIndiceCarta(), aux.getFigura(), aux.getValor(), aux.getImagen());
                    EliminarCarta(aux.getFigura(), aux.getValor());
                    aux = aux.getProximo();
                    mazoJugador.InsertarCarta(aux.getIndiceCarta(), aux.getFigura(), aux.getValor(), aux.getImagen());
                    EliminarCarta(aux.getFigura(), aux.getValor());
                    aux = aux.getProximo();
                    repartir++;
                }
            } else {
                while (repartir <= 4) {
                    mazoJugador.InsertarCarta(aux.getIndiceCarta(), aux.getFigura(), aux.getValor(), aux.getImagen());
                    EliminarCarta(aux.getFigura(), aux.getValor());
                    aux = aux.getProximo();
                    mazoComputadora.InsertarCarta(aux.getIndiceCarta(), aux.getFigura(), aux.getValor(), aux.getImagen());
                    EliminarCarta(aux.getFigura(), aux.getValor());
                    aux = aux.getProximo();
                    repartir++;
                }
            }
            repartir = 1;
            if (reparteMesa) {
                while (repartir <= 4) {
                    mazoMesa.InsertarCarta(aux.getIndiceCarta(), aux.getFigura(), aux.getValor(), aux.getImagen());
                    EliminarCarta(aux.getFigura(), aux.getValor());
                    aux = aux.getProximo();
                    repartir++;
                }
            }
        }
    }

    public Carta BuscarCarta(Mazo auxiliar, String tipo, String numero) {
        Carta carta = auxiliar._mazo;

        if (auxiliar._mazo != null) {
            while (carta != null) {
                if (carta.getFigura().equals(tipo) && carta.getValor().equals(numero)) {
                    return carta;
                }
                carta = carta.getProximo();
            }
        } else {
            System.out.println("\nUsted ya no tiene cartas");
            return carta = null;
        }
        return carta;
    }
}
