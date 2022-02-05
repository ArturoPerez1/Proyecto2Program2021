package modelo;

public class Cola {
	private Nodo inicioCola, finalCola;
	private String colaTexto = " ";

	public Nodo getInicioCola() {
		return inicioCola;
	}

	public Nodo getFinalCola() {
		return finalCola;
	}

	public String getColaTexto() {
		return colaTexto;
	}

	public Cola() {
		inicioCola = null;
		finalCola = null;
	}

	public boolean colaVacia() {
		if (inicioCola == null) {
			return true;
		} else {
			return false;
		}
	}

	public void insertar(int id, String figura, String imagen) {
		Nodo nuevoNodo = new Nodo();
		
		nuevoNodo.id = id;
		nuevoNodo.figura = figura;
		nuevoNodo.imagen = imagen;
		nuevoNodo.siguiente = null;

		if (colaVacia()) {
			inicioCola = nuevoNodo;
			finalCola = nuevoNodo;
		} else {
			finalCola.siguiente = nuevoNodo;
			finalCola = nuevoNodo;
		}
	}

	public void mostrarContenido() {
		Nodo recorrido = inicioCola;

		while (recorrido != null) {
			colaTexto += recorrido.id + recorrido.figura + recorrido.imagen+ " ->";
			recorrido = recorrido.siguiente;
		}
		colaTexto += " null";
		System.out.println(colaTexto);
	}
}
