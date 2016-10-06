package pq;

import java.io.*;
import java.util.HashMap;

public class Ficheros {
	
	File fichero = null;
	FileReader fr = null;
	BufferedReader br = null;
	FileWriter archivo = null;
	PrintWriter pw = null;
	String ruta = "C:/workspace/ADAT_A_1_2_BBDD/src/pq/datos.txt";

	public HashMap<String, String> escribirFichero(HashMap<String,String> mapa) {

		
		String titulo;
		String director;

		try {
			archivo = new FileWriter(ruta);
			pw = new PrintWriter(archivo);
			
			for (HashMap.Entry<String, String> entry : mapa.entrySet()) {
				titulo = entry.getKey();
				director = entry.getValue();
				archivo.write(titulo + ";" + director + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (null != archivo)
					archivo.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return mapa;

	}
	
	
	public HashMap<String, String> leerFichero (){
		
		HashMap<String,String> mapa = new HashMap<String,String>();
		
		
		
		try {
			fichero = new File(ruta);
			fr = new FileReader(fichero);
			br = new BufferedReader(fr);
			
			
			String lineaActual;
			
			

			while
			 ((lineaActual = br.readLine()) != null) {
				
				String[]partes =lineaActual.split(";");
				mapa.put(partes[0], partes[1]);
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (null != fr)
					br.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return mapa;
		
		
	}

}
