package bi;

import java.io.*;
import java.sql.*;

public class Metodos {
	BufferedReader tcl = new BufferedReader(new InputStreamReader(System.in));

	int matricula;
	String nombre, grupo;

	public void altas() throws IOException {
		Connection con = Conexion.getConnection();

		try {
			PreparedStatement pstmt = con
					.prepareStatement("insert into alumnos(nombre,matricula,grupo)values(?,?,?)");

			System.out.println("nombre del alumno:");
			nombre = tcl.readLine();
			System.out.println("matricula del alumno:");
			matricula = Integer.parseInt(tcl.readLine());
			System.out.println("grupo del alumno:");
			grupo = tcl.readLine();

			pstmt.setString(1, nombre);
			pstmt.setInt(2, matricula);
			pstmt.setString(3, grupo);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("ocurrio algun error");
		}

	}

	public void mostrar() {
		Connection con = Conexion.getConnection();

		try {
			Statement st = con.createStatement();
			ResultSet tabla = st.executeQuery("select * from alumnos");
			while (tabla.next()) {
				System.out.println("nombre: " + tabla.getString("nombre"));
				System.out.println("matricula: " + tabla.getInt("matricula")
						+ "\n");
				System.out.println("grupo: " + tabla.getString("grupo") + "\n");

			}
		} catch (SQLException e) {
			System.out.println("error al mostrar");

		}
	}

	public void borrar() {
		Connection con = Conexion.getConnection();
		try {
			PreparedStatement pstmt = con
					.prepareStatement("delete from alumnos where matricula=?");

			pstmt.setString(1, nombre);
			pstmt.setInt(2, matricula);
			pstmt.setString(3, grupo);
			pstmt.executeUpdate();
			pstmt.executeUpdate();

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("ocurrio un error");
		}
	}

	public void modificar() {
		Connection con = Conexion.getConnection();
		try {
			PreparedStatement pstmt = con
					.prepareStatement("update alumnos set nombre, matricula=? where grupo");

			pstmt.setString(1, nombre);
			pstmt.setInt(2, matricula);
			pstmt.setString(3, grupo);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("ocurrio un error");
		}
	}

	public void consultas() throws IOException {
		String aux;
		Connection con = Conexion.getConnection();
		try {
			Statement st = con.createStatement();
			System.out.println("digite la matricula del alumno a consultar");
			aux = tcl.readLine();
			matricula = Integer.parseInt(aux);
			ResultSet tabla = st
					.executeQuery("select * from alumnos where matricula="
							+ matricula);
			if (tabla.next()) {
				System.out.println(" matricula: " + tabla.getInt("matricula")
						+ "\n");
				System.out.println("nombre: " + tabla.getString("nombre"));
				System.out.println("grupo: " + tabla.getFloat("grupo") + "\n");

			}
		} catch (SQLException e) {
			System.out.println("Error al mostrar");
		}
	}

}
