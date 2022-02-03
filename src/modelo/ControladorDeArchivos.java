package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import vista.Vista;

public class ControladorDeArchivos {
	File file;
	File folder;
	Vista vista;

	public ControladorDeArchivos(Vista vista) {
		this.folder = new File("FolderGuardados");
		this.file = new File("FolderGuardados\\NombreDelJugador");
		this.vista = vista;
	}

	public void RegistrarNombreJugador() {
		try {
			boolean folderCreate = folder.mkdir();
			boolean fileCreate = file.createNewFile();

			if (folderCreate && fileCreate) {
				FileWriter writeFile = new FileWriter(file);
				writeFile.write(vista.getTextoJTextField());
				writeFile.close();
				vista.mensaje("Se ha creado de forma exitosa su archivo y carpeta");
			} else {
				FileWriter writeFile = new FileWriter(file);
				writeFile.write(vista.getTextoJTextField());
				writeFile.close();
			}
		} catch (IOException e) {
			vista.mensaje("Hubo una excepcion al hora de crear el archivo: " + e);
		}
	}

}
