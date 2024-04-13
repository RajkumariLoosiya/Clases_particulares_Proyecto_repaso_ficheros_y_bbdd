package ejercicio_files_y_basesdedatos.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ejercicio_files_y_basesdedatos.model.Departamento;
import ejercicio_files_y_basesdedatos.model.Empleado;
import ejercicio_files_y_basesdedatos.model.Persona;

public class OperationsDB {

	private Connection conx;

	public OperationsDB(Connection conx) {
		this.conx = conx;
	}

	public void guardarEmpleado(Empleado empleEntra) {

		String query = "INSERT INTO Empleados (persona_id,Cargo,Salario,departamento_id) VALUES (?,?,?,?)";

		try {

			PreparedStatement pst = conx.prepareStatement(query);

			pst.setInt(1, empleEntra.getId());
			pst.setString(2, empleEntra.getCargo());
			pst.setDouble(3, empleEntra.getSalario());
			pst.setInt(4, empleEntra.getDepartamento().getId());
			pst.executeUpdate();

			System.out.println("Empleado guardado con éxito" + empleEntra.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void guardarDepartamento(Departamento departamento) {

		String query = "INSERT INTO Departamentos (Id,Nombre) VALUES (?,?)";

		try {

			PreparedStatement pst = conx.prepareStatement(query);

			pst.setInt(1, departamento.getId()); 
			pst.setString(2, departamento.getNombre());

			pst.executeUpdate();

			System.out.println("Departamento guardado con éxito" + departamento.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void guardarPersona(Persona persona) {

		String query = "INSERT INTO PERSONAS (Nombre,edad) VALUES (?,?)";

		try {

			PreparedStatement pst = conx.prepareStatement(query);

			pst.setString(1, persona.getNombre());
			pst.setInt(2, persona.getEdad());

			pst.executeUpdate();

			System.out.println("Persona guardada con éxito" + persona.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
