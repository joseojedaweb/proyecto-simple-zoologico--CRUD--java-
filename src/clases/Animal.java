package clases;

public class Animal {

	// ATRIBUTOS. IDENTIFICACION
	private String id;
	private String nombre;

	// ATRIBUTOS. INFO BASICA
	private String especie;
	private String sexo;
	private String fechaNacimiento;
	private double peso;
	private double talla;

	// ATRIBUTOS. HISTORIAL MEDICO
	private boolean vacunas;
	private boolean enfermedadesExistente;

	// CONSTRUCTOR VACIO
	public Animal() {

	}

	// CONSTRUCTOR PARAMETRIZADO
	public Animal(String id, String nombre, String especie, String sexo, String fechaNacimiento, double peso,
			double talla, boolean vacunas, boolean enfermedadesExistente) {
		this.id = id;
		this.nombre = nombre;
		this.especie = especie;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.peso = peso;
		this.talla = talla;
		this.vacunas = vacunas;
		this.enfermedadesExistente = enfermedadesExistente;
	}

	// GETTER Y SETTERS
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getTalla() {
		return talla;
	}

	public void setTalla(double talla) {
		this.talla = talla;
	}

	public boolean isVacunas() {
		return vacunas;
	}

	public void setVacunas(boolean vacunas) {
		this.vacunas = vacunas;
	}

	public boolean isEnfermedadesExistente() {
		return enfermedadesExistente;
	}

	public void setEnfermedadesExistente(boolean enfermedadesExistente) {
		this.enfermedadesExistente = enfermedadesExistente;
	}

	// METODO toString
	@Override
	public String toString() {
		return "Animal [id: " + id + " | especie: " + nombre + " | grupo animal: " + especie + " | sexo: " + sexo
				+ " | fecha Nacimiento: " + fechaNacimiento + " | peso: " + peso + "Kg | talla: " + talla + " m | vacunas: "
				+ vacunas + " | enfermedadesExistente: " + enfermedadesExistente + "]";
	}

}
