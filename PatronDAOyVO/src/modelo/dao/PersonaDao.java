package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.conexion.Conexion;
import modelo.vo.PersonaVo;

/**
 * Clase que permite el acceso a la base de datos
 * 
 * @author Alex
 *
 */

//Cuando utilizamos estas clases, aplicamos el patrón Data Access Object o DAO,
//básicamente este patrón consiste en centralizar los procesos de acceso a la base de datos
//evitando inconsistencias y posibles problemáticas cuando esto se realiza a lo largo de la aplicación.
//Con este patrón independizamos la lógica de negocio de la lógica de acceso a datos obteniendo mayor 
//organización y flexibilidad en el sistema.

public class PersonaDao {

	public void registrarPersona(PersonaVo miPersona) {
		Conexion conex = new Conexion();

		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO personas VALUES ('" + miPersona.getIdPersona() + "', '"
					+ miPersona.getNombrePersona() + "', '" + miPersona.getEdadPersona() + "', '"
					+ miPersona.getProfesionPersona() + "', '" + miPersona.getTelefonoPersona() + "')");
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro");
		}
	}

	public PersonaVo buscarPersona(int codigo) {
		Conexion conex = new Conexion();
		PersonaVo persona = new PersonaVo();
		boolean existe = false;
		try {
			// Statement estatuto = conex.getConnection().createStatement();
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM personas where id = ? ");
			consulta.setInt(1, codigo);
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				existe = true;
				persona.setIdPersona(Integer.parseInt(res.getString("id")));
				persona.setNombrePersona(res.getString("nombre"));
				persona.setEdadPersona(Integer.parseInt(res.getString("edad")));
				persona.setProfesionPersona(res.getString("profesion"));
				persona.setTelefonoPersona(Integer.parseInt(res.getString("telefono")));
			}
			res.close();
			conex.desconectar();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error, no se conecto");
			System.out.println(e);
		}

		if (existe) {
			return persona;
		} else
			return null;
	}

	public void modificarPersona(PersonaVo miPersona) throws SQLException {

		Conexion conex = new Conexion();
		PreparedStatement estatuto = null;
		try {
			String consulta = "UPDATE personas SET nombre = ? , edad = ? , telefono = ? ,profesion = ?  WHERE id = ?";
			estatuto = conex.getConnection().prepareStatement(consulta);

			estatuto.setString(1, miPersona.getNombrePersona());
			estatuto.setInt(2, miPersona.getEdadPersona());
			estatuto.setInt(3, miPersona.getTelefonoPersona());
			estatuto.setString(4, miPersona.getProfesionPersona());
			estatuto.setInt(5, miPersona.getIdPersona());

			int retorno = estatuto.executeUpdate();
			JOptionPane.showMessageDialog(null, "se ha modificado ", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "error al editar registro", "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			conex.desconectar();
			estatuto.close();

		}

	}

	public void eliminarPersona(int codigo) throws SQLException {

		Conexion conex = new Conexion();
		Statement estatuto = null;
		try {
			estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("DELETE FROM personas WHERE id = " + codigo);

			JOptionPane.showMessageDialog(null, "Se Ha Eliminado Correctamente", "Informacion",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se elimino correctamente ");
			System.out.println(e.getMessage());
			e.printStackTrace();
			estatuto.close();
			conex.desconectar();

		}
	}

}
