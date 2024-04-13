package ejercicio_files_y_basesdedatos.model;

public class Empleado extends Persona {

	private String cargo;

	private double salario;

	private Departamento departamento;

	public Empleado(Persona persona, String cargo, double salario, Departamento departamento) {
		super(persona.getId(), persona.getNombre(), persona.getEdad());
		this.cargo = cargo;
		this.salario = salario;
		this.departamento = departamento;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Empleado [cargo=" + cargo + ", salario=" + salario + ", departamento=" + departamento.getNombre() + "]";
	}

}
