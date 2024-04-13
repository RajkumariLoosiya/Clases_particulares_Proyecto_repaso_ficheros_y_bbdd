package ejercicio_files_y_basesdedatos.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import ejercicio_files_y_basesdedatos.model.Departamento;
import ejercicio_files_y_basesdedatos.model.Empleado;
import ejercicio_files_y_basesdedatos.model.Persona;
import ejercicio_files_y_basesdedatos.util.HerramientasMigue;

public class Logica_Negocio extends HerramientasMigue {

	public void extraccionDeDatos() {

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

}
