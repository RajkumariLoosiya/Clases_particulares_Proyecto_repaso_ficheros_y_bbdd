package ejercicio_files_y_basesdedatos.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ejercicio_files_y_basesdedatos.db.OperationsDB;
import ejercicio_files_y_basesdedatos.model.Departamento;
import ejercicio_files_y_basesdedatos.model.Empleado;
import ejercicio_files_y_basesdedatos.model.Persona;
import ejercicio_files_y_basesdedatos.util.HerramientasMigue;

public class Logica_Negocio extends HerramientasMigue{

	public void extraccionDeDatos(Connection conx) {
		
		OperationsDB opdb = new OperationsDB(conx);

		String url = "C:\\Users\\migue\\Desktop\\empleados.txt";

		String linea = "";

		List<Empleado> listaEmpleados = new ArrayList<>();

		List<Departamento> listaDepartamentos = new ArrayList<>();

		List<Persona> listaPersonas = new ArrayList<>();

		try {

			BufferedReader reader = new BufferedReader(new FileReader(url));

			while ((linea = reader.readLine()) != null) {

				String[] datos = linea.split(",");

				Persona persona = new Persona(Integer.parseInt(datos[0]), datos[1], Integer.parseInt(datos[2]));

				Departamento departamento = new Departamento(Integer.parseInt(datos[5]), datos[6]);

				Empleado emple = new Empleado(persona, datos[3], Integer.parseInt(datos[4]), departamento);

				listaPersonas.add(persona);

				if (! existeEnLista(Integer.parseInt(datos[5]), listaDepartamentos)) {
					listaDepartamentos.add(departamento);
				}

				listaEmpleados.add(emple);

			}
			
			// Insercciones datos base datos. 
			
// Insercción de departamentos 
			
//			for(Departamento i: listaDepartamentos) {
//				opdb.guardarDepartamento(i);
//			}

// Insercción de personas 
			
//			for(Persona i: listaPersonas) {
//				opdb.guardarPersona(i);
//			}
		
			for(Empleado i: listaEmpleados) {
				opdb.guardarEmpleado(i);
			}

			lecturaElementosColeccion(listaDepartamentos);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean existeEnLista(int dato, List<Departamento> listaEntrada) {

		boolean evitar = false;

		for (Departamento i : listaEntrada) {

			if (i.getId() == dato) {
				return true;
			}

		}
		return false;
	}
	
	public List<Persona> extraerListaPersonas(Connection conx) {
		
		List<Persona> listaPersonas = new ArrayList<>();
		
		String query = "SELECT * FROM Personas"; 
		
		try {
			
			PreparedStatement pst = conx.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				String nombre = rs.getString("NOMBRE");
				int edad = rs.getInt("EDAD");
				
				System.out.println(id + nombre + edad);
				
				Persona personaGuardar = new Persona(id, nombre, edad);
				listaPersonas.add(personaGuardar);
				
				System.out.println("Persona guardada con éxito");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaPersonas; 
		
	}
	
public List<Departamento> extraerListaDepartamentos(Connection conx) {
		
		List<Departamento> listaDepartamentos = new ArrayList<>();
		
		String query = "SELECT * FROM Departamentos"; 
		
		try {
			
			PreparedStatement pst = conx.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				String nombre = rs.getString("NOMBRE");
				
				System.out.println(id + nombre);
				
				Departamento departamentoGuardar = new Departamento(id, nombre);
				listaDepartamentos.add(departamentoGuardar);
				
				System.out.println("Departamento guardado con éxito");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaDepartamentos; 
		
	}

}
