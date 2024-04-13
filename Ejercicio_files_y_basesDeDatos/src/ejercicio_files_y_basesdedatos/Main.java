package ejercicio_files_y_basesdedatos;

import ejercicio_files_y_basesdedatos.db.ConexionDB;
import ejercicio_files_y_basesdedatos.db.OperationsDB;
import ejercicio_files_y_basesdedatos.services.Logica_Negocio;

public class Main {
	
	public static void main(String[] args) {
		
		ConexionDB dbc = new ConexionDB(); 
		
		Logica_Negocio ln = new Logica_Negocio(); 
		
//		ln.extraccionDeDatos(dbc.getConx());
		
		ln.extraerListaPersonas(dbc.getConx());
		ln.extraerListaDepartamentos(dbc.getConx());
		
	}

}
