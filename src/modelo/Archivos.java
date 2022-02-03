package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import vista.Vista;

public class Archivos {
	Vista vista;

	public void GuardarMazoJugador(Mazo jugador) {
		File folder = new File("CarpetaDelJuego");
		File file = new File("CarpetaDelJuego\\MazoJugador.txt");
		Mazo aux1 = jugador;
		String tipo, numero;

		try {
			boolean folderCreated = folder.mkdir();
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
			if (fileCreated && folderCreated) {
				// System.out.println("\nArchivo creado con exitos");
			} else {
				// System.out.println("El archivo ya existe");
			}
		} catch (IOException e) {
			System.out.println("Error al crear el archivo " + e);
		}
	}

	public void GuardarMazoComputadora(Mazo jugador) {
		File folder = new File("CarpetaDelJuego");
		File file = new File("CarpetaDelJuego\\MazoComputadora.txt");
		Mazo aux1 = jugador;
		String tipo, numero;

		try {
			boolean folderCreated = folder.mkdir();
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
			if (fileCreated && folderCreated) {
				// System.out.println("\nArchivo creado con exitos");
			} else {
				// System.out.println("El archivo ya existe");
			}
		} catch (IOException e) {
			System.out.println("Error al crear el archivo " + e);
		}
	}

	public void GuardarMazoMesa(Mazo jugador) {
		File folder = new File("CarpetaDelJuego");
		File file = new File("CarpetaDelJuego\\MazoMesa.txt");
		Mazo aux1 = jugador;
		String tipo, numero;

		try {
			boolean folderCreated = folder.mkdir();
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
			if (fileCreated && folderCreated) {
				// System.out.println("\nArchivo creado con exitos");
			} else {
				// System.out.println("El archivo ya existe");
			}
		} catch (IOException e) {
			System.out.println("Error al crear el archivo " + e);
		}
	}

	public void GuardarMazoPilon(Mazo jugador) {
		File folder = new File("CarpetaDelJuego");
		File file = new File("CarpetaDelJuego\\MazoPilon.txt");
		Mazo aux1 = jugador;
		String tipo, numero;

		try {
			boolean folderCreated = folder.mkdir();
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
			if (fileCreated && folderCreated) {
				// System.out.println("\nArchivo creado con exitos");
			} else {
				// System.out.println("El archivo ya existe");
			}
		} catch (IOException e) {
			System.out.println("Error al crear el archivo " + e);
		}
	}

	public void GuardarMazoAcumuladorJugador(Mazo jugador) {
		File folder = new File("CarpetaDelJuego");
		File file = new File("CarpetaDelJuego\\MazoAcumuladorJugador.txt");
		Mazo aux1 = jugador;
		String tipo, numero;

		try {
			boolean folderCreated = folder.mkdir();
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
			if (fileCreated && folderCreated) {
				// System.out.println("\nArchivo creado con exitos");
			} else {
				// System.out.println("El archivo ya existe");
			}
		} catch (IOException e) {
			System.out.println("Error al crear el archivo " + e);
		}
	}

	public void GuardarMazoAcumuladorComputadora(Mazo jugador) {
		File folder = new File("CarpetaDelJuego");
		File file = new File("CarpetaDelJuego\\MazoAcumuladorComputadora.txt");
		Mazo aux1 = jugador;
		String tipo, numero;

		try {
			boolean folderCreated = folder.mkdir();
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
			if (fileCreated && folderCreated) {
				// System.out.println("\nArchivo creado con exitos");
			} else {
				// System.out.println("El archivo ya existe");
			}
		} catch (IOException e) {
			System.out.println("Error al crear el archivo " + e);
		}
	}

	public void GuardarNombre(Vista vista) {
		this.vista = vista;
		File folder = new File("CarpetaDelJuego");
		File file = new File("CarpetaDelJuego\\Nombre.txt");

		try {
			boolean folderCreated = folder.mkdir();
			boolean fileCreated = file.createNewFile();
			FileWriter f = new FileWriter(file);
			f.write(vista.getTextoJTextField());
			f.close();
			if (fileCreated && folderCreated) {
				// System.out.println("\nArchivo creado con exitos");
			} else {
				// System.out.println("El archivo ya existe");
			}
		} catch (IOException e) {
			System.out.println("Error al crear el archivo " + e);
		}
	}

	public void GuardarTurno(boolean turno) {
		File folder = new File("CarpetaDelJuego");
		File file = new File("CarpetaDelJuego\\Turno.txt");
		boolean aux = turno;

		try {
			boolean folderCreated = folder.mkdir();
			boolean fileCreated = file.createNewFile();
			FileWriter f = new FileWriter(file);
			f.write(aux + "\n");
			f.close();
			if (fileCreated && folderCreated) {
				/// System.out.println("\nArchivo creado con exitos");
			} else {
				// System.out.println("El archivo ya existe");
			}
		} catch (IOException e) {
			System.out.println("Error al crear el archivo " + e);
		}
	}

	public void GuardarPuntosJugador(int puntos) {
		File folder = new File("CarpetaDelJuego");
		File file = new File("CarpetaDelJuego\\PuntosJugador.txt");
		int aux = puntos;

		try {
			boolean folderCreated = folder.mkdir();
			boolean fileCreated = file.createNewFile();
			FileWriter f = new FileWriter(file);
			f.write(aux + "\n");
			f.close();
			if (fileCreated && folderCreated) {
				// System.out.println("\nArchivo creado con exitos");
			} else {
				// System.out.println("El archivo ya existe");
			}
		} catch (IOException e) {
			System.out.println("Error al crear el archivo " + e);
		}
	}

	public void GuardarPuntosComputadora(int puntos) {
		File folder = new File("CarpetaDelJuego");
		File file = new File("CarpetaDelJuego\\PuntosComputadora.txt");
		int aux = puntos;

		try {
			boolean folderCreated = folder.mkdir();
			boolean fileCreated = file.createNewFile();
			FileWriter f = new FileWriter(file);
			f.write(aux + "\n");
			f.close();
			if (fileCreated && folderCreated) {
				// System.out.println("\nArchivo creado con exitos");
			} else {
				// System.out.println("El archivo ya existe");
			}
		} catch (IOException e) {
			System.out.println("Error al crear el archivo " + e);
		}
	}

}
