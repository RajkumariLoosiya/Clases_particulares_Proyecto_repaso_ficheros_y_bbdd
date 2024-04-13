package ejercicio_files_y_basesdedatos.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ejercicio_files_y_basesdedatos.model.Departamento;
import ejercicio_files_y_basesdedatos.model.Empleado;
import ejercicio_files_y_basesdedatos.model.Persona;

public class OperationsDB {

	private Connection conx;

	public OperationsDB(Connection conx) {
		this.conx = conx;
	}

	public void guardarEmpleado(Empleado empleEntra) {

		String query = "INSERT INTO Empleados (Nombre,Edad,Cargo,Salario,IdDepartamento) VALUES (?,?,?,?,?)";

		try {

			PreparedStatement pst = conx.prepareStatement(query);

			pst.setString(1, empleEntra.getNombre());
			pst.setInt(2, empleEntra.getEdad());
			pst.setString(3, empleEntra.getCargo());
			pst.setDouble(4, empleEntra.getSalario());
			pst.setInt(5, empleEntra.getDepartamento().getId());
			pst.executeUpdate();

			System.out.println("Empleado guardado con éxito");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void guardarDepartamento(Departamento departamento) {

		String query = "INSERT INTO Departamentos (Id,Nombre) VALUES (?,?)";

		try {

			PreparedStatement pst = conx.prepareStatement(query);

			pst.setInt(0, departamento.getId());
			pst.setString(1, departamento.getNombre());

			pst.executeUpdate();

			System.out.println("Departamento guardado con éxito");

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

			System.out.println("Persona guardada con éxito");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
