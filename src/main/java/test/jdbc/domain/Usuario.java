package test.jdbc.domain;

public class Usuario {

	private int personaId;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;

	public Usuario() {

	}

	public Usuario(int personaId) {
		super();
		this.personaId = personaId;
	}

	public Usuario(String nombre, String apellido, String email, String telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}

	public Usuario(int personaId, String nombre, String apellido, String email, String telefono) {
		super();
		this.personaId = personaId;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}

	public int getPersonaId() {
		return personaId;
	}

	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Usuario [personaId=" + personaId + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + "]";
	}

}
