package test.jdbc.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.jdbc.domain.Usuario;

public class PersonaDAO {

	private Connection conexionTransaccional;
	private static final String SQL_SELECT = "SELECT persona_id, nombre, apellido, email, telefono FROM usuarios";
	private static final String SQL_INSERT = "INSERT INTO usuarios(nombre, apellido, email,telefono) VALUES (?, ?, ?, ?)";
	private static final String SQL_DELETE = "DELETE FROM usuarios WHERE (persona_id=?)";
	private static final String SQL_UPDATE = "UPDATE usuarios SET nombre= ?, apellido= ?, email=?, telefono=? WHERE (persona_id=?)";

	public PersonaDAO() {

	}

	public PersonaDAO(Connection conexionTransaccional) {

		this.conexionTransaccional = conexionTransaccional;
	}

	public List<Usuario> seleccionar() throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Usuario usuario = null;
		List<Usuario> usuarios = new ArrayList<>();
		try {
			con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
			stmt = con.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int personaId = rs.getInt("persona_id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String email = rs.getString("email");
				String telefono = rs.getString("telefono");
				usuario = new Usuario(personaId, nombre, apellido, email, telefono);
				usuarios.add(usuario);

			}
		} finally {

			Conexion.close(rs);
			Conexion.close(stmt);
			if (this.conexionTransaccional == null)
				Conexion.close(con);
		}

		return usuarios;
	}

	public int insertar(Usuario persona) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		int registros = 0;
		try {
			con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
			stmt = con.prepareStatement(SQL_INSERT);
			stmt.setString(1, persona.getNombre());
			stmt.setString(2, persona.getApellido());
			stmt.setString(3, persona.getEmail());
			stmt.setString(4, persona.getTelefono());
			registros = stmt.executeUpdate();
		} finally {

			Conexion.close(stmt);
			if (this.conexionTransaccional == null)
				Conexion.close(con);

		}
		return registros;
	}

	public int delete(int id) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		int registros = 0;
		try {

			con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
			stmt = con.prepareStatement(SQL_DELETE);
			stmt.setInt(1, id);
			registros = stmt.executeUpdate();

		} finally {

			Conexion.close(stmt);
			if (this.conexionTransaccional == null)
				Conexion.close(con);
		}
		return registros;
	}

	public int update(Usuario persona) throws SQLException {

		Connection con = null;
		PreparedStatement stmt = null;
		int registros = 0;
		try {
			con = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
			stmt = con.prepareStatement(SQL_UPDATE);
			stmt.setString(1, persona.getNombre());
			stmt.setString(2, persona.getApellido());
			stmt.setString(3, persona.getEmail());
			stmt.setString(4, persona.getTelefono());
			stmt.setInt(5, persona.getPersonaId());
			registros = stmt.executeUpdate();

		} finally {

			Conexion.close(stmt);
			if (this.conexionTransaccional == null)
				Conexion.close(con);
		}
		return registros;
	}

}
