package ejercicio_files_y_basesdedatos.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConexionDB {

	private Connection conx;

	public ConexionDB() {
		stablishConx(); 
	}

	public void stablishConx() {

		try {

			conx = DriverManager.getConnection("jdbc:h2:~/empresa;DB_CLOSE_DELAY=-1");
//			createTables();
			
			System.out.println("Conexión establecida con éxito");
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createTables() {

		try {

			Statement st = conx.createStatement();

			String queryPersonas = "CREATE TABLE IF NOT EXISTS Personas (id INT PRIMARY KEY AUTO_INCREMENT,nombre VARCHAR(255),edad INT);";

			String queryDepartamentos = "CREATE TABLE IF NOT EXISTS Departamentos (id INT PRIMARY KEY,nombre VARCHAR(255));";

			String queryEmpleados = "CREATE TABLE Empleados ("
					+ "id INT PRIMARY KEY AUTO_INCREMENT,"
					+ "persona_id INT,"
					+ "cargo VARCHAR(255),"
					+ "salario DOUBLE,departamento_id INT,"
					+ "FOREIGN KEY (persona_id) REFERENCES Personas(id),"
					+ "FOREIGN KEY (departamento_id) REFERENCES Departamentos(id));";

			st.executeUpdate(queryPersonas);

			st.executeUpdate(queryDepartamentos);

			st.executeUpdate(queryEmpleados);

			System.out.println("Tablas creadas con éxito");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void closeConx() {
		try {

			if (conx != null && !conx.isClosed()) {

				conx.close();
				
				System.out.println("Conexión cerrada con éxito");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConx() {
		return conx;
	}
	
	

}
