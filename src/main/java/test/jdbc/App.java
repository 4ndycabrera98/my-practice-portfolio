package test.jdbc;

import java.sql.*;
import java.util.List;

import test.jdbc.datos.Conexion;
import test.jdbc.datos.PersonaDAO;
import test.jdbc.domain.Usuario;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Connection conn = null;

		try {
			conn = Conexion.getConnection();
			if (conn.getAutoCommit()) {
				conn.setAutoCommit(false);
			}

			PersonaDAO pd = new PersonaDAO(conn);

			Usuario usuarioCambio = new Usuario();

			usuarioCambio.setPersonaId(2);
			usuarioCambio.setNombre("Roman");
			usuarioCambio.setApellido("Perez");
			usuarioCambio.setEmail("rperes@gmail");
			usuarioCambio.setTelefono("119818285");
			pd.update(usuarioCambio);

			Usuario nuevoUsuario = new Usuario();

			nuevoUsuario.setNombre("Adrian");
			nuevoUsuario.setApellido("Gutierrez");
			nuevoUsuario.setEmail("Gutierrez@gmail");
			nuevoUsuario.setTelefono("987672612");
			pd.insertar(nuevoUsuario);

			conn.commit();
			System.out.println("se ha ejecutado correctamente el commit");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
			System.out.println("Entramos al RoolBack");
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace(System.out);
			}
		}

	}
}
