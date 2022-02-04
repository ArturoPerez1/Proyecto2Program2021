package modelo;

import vista.Vista;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Archivos {
	Vista vista;

	public void GuardarMazoJugador(Mazo jugador) {
		File file = new File("assets/baseDatos/MazoJugador.txt");
		Mazo aux1 = jugador;
		String tipo, numero;

		try {
			boolean fileCreated = file.createNewFile();
			FileWriter f = new FileWriter(file);
			while (aux1.getMazo() != null) {
				tipo = aux1.getMazo().getTipo();
				numero = aux1.getMazo().getNumero();
				f.write(tipo + "\n");
				f.write(numero + "\n");
				aux1.setMazo(aux1.getMazo().getProximo());
			}
			f.close();
		} catch (IOException e) {
			System.out.println("Error al crear el archivo " + e);
		}
	}

	public void GuardarMazoComputadora(Mazo jugador) {
		File file = new File("assets/baseDatos/MazoComputadora.txt");
		Mazo aux1 = jugador;
		String tipo, numero;

		try {
			boolean fileCreated = file.createNewFile();
			FileWriter f = new FileWriter(file);
			while (aux1.getMazo() != null) {
				tipo = aux1.getMazo().getTipo();
				numero = aux1.getMazo().getNumero();
				f.write(tipo + "\n");
				f.write(numero + "\n");
				aux1.setMazo(aux1.getMazo().getProximo());
			}
			f.close();
		} catch (IOException e) {
			System.out.println("Error al crear el archivo " + e);
		}
	}

	public void GuardarMazoMesa(Mazo jugador) {
		File file = new File("assets/baseDatos/MazoMesa.txt");
		Mazo aux1 = jugador;
		String tipo, numero;

		try {
			boolean fileCreated = file.createNewFile();
			FileWriter f = new FileWriter(file);
			while (aux1.getMazo() != null) {
				tipo = aux1.getMazo().getTipo();
				numero = aux1.getMazo().getNumero();
				f.write(tipo + "\n");
				f.write(numero + "\n");
				aux1.setMazo(aux1.getMazo().getProximo());
			}
			f.close();
		} catch (IOException e) {
			System.out.println("Error al crear el archivo " + e);
		}
	}

	public void GuardarMazoPilon(Mazo jugador) {
		File file = new File("assets/baseDatos/MazoPilon.txt");
		Mazo aux1 = jugador;
		String tipo, numero;

		try {
			boolean fileCreated = file.createNewFile();
			FileWriter f = new FileWriter(file);
			while (aux1.getMazo() != null) {
				tipo = aux1.getMazo().getTipo();
				numero = aux1.getMazo().getNumero();
				f.write(tipo + "\n");
				f.write(numero + "\n");
				aux1.setMazo(aux1.getMazo().getProximo());
			}
			f.close();
		} catch (IOException e) {
			System.out.println("Error al crear el archivo " + e);
		}
	}

	public void GuardarMazoAcumuladorJugador(Mazo jugador) {
		File file = new File("assets/baseDatos/MazoAcumuladorJugador.txt");
		Mazo aux1 = jugador;
		String tipo, numero;

		try {
			boolean fileCreated = file.createNewFile();
			FileWriter f = new FileWriter(file);
			while (aux1.getMazo() != null) {
				tipo = aux1.getMazo().getTipo();
				numero = aux1.getMazo().getNumero();
				f.write(tipo + "\n");
				f.write(numero + "\n");
				aux1.setMazo(aux1.getMazo().getProximo());
			}
			f.close();
		} catch (IOException e) {
			System.out.println("Error al crear el archivo " + e);
		}
	}

	public void GuardarMazoAcumuladorComputadora(Mazo jugador) {
		File file = new File("assets/baseDatos/MazoAcumuladorComputadora.txt");
		Mazo aux1 = jugador;
		String tipo, numero;

		try {
			boolean fileCreated = file.createNewFile();
			FileWriter f = new FileWriter(file);
			while (aux1.getMazo() != null) {
				tipo = aux1.getMazo().getTipo();
				numero = aux1.getMazo().getNumero();
				f.write(tipo + "\n");
				f.write(numero + "\n");
				aux1.setMazo(aux1.getMazo().getProximo());
			}
			f.close();
		} catch (IOException e) {
			System.out.println("Error al crear el archivo " + e);
		}
	}

	public void GuardarNombre(Vista vista) {
		this.vista = vista;
		File file = new File("assets/baseDatos/Nombre.txt");

		try {
			boolean fileCreated = file.createNewFile();
			FileWriter f = new FileWriter(file);
			f.write(vista.getTextoJTextField());
			f.close();
		} catch (IOException e) {
			System.out.println("Error al crear el archivo " + e);
		}
	}

	public void GuardarTurno(boolean turno) {
		File file = new File("assets/baseDatos/Turno.txt");
		boolean aux = turno;

		try {
			boolean fileCreated = file.createNewFile();
			FileWriter f = new FileWriter(file);
			f.write(aux + "\n");
			f.close();
		} catch (IOException e) {
			System.out.println("Error al crear el archivo " + e);
		}
	}

	public void GuardarPuntosJugador(int puntos) {
		File file = new File("assets/baseDatos/PuntosJugador.txt");
		int aux = puntos;

		try {

			boolean fileCreated = file.createNewFile();
			FileWriter f = new FileWriter(file);
			f.write(aux + "\n");
			f.close();
		} catch (IOException e) {
			System.out.println("Error al crear el archivo " + e);
		}
	}

	public void GuardarPuntosComputadora(int puntos) {
		File file = new File("assets/baseDatos/PuntosComputadora.txt");
		int aux = puntos;

		try {
			boolean fileCreated = file.createNewFile();
			FileWriter f = new FileWriter(file);
			f.write(aux + "\n");
			f.close();
		} catch (IOException e) {
			System.out.println("Error al crear el archivo " + e);
		}
	}

}
