package controlador;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.dao.PersonaDao;
import modelo.vo.PersonaVo;

public class Principal {

	public static void main(String[] args) throws SQLException {
		PersonaDao miDao = new PersonaDao();
		// solicitamos los datos al user
		int idIngresado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la persona a modificar"));

		if (miDao.buscarPersona(idIngresado) != null) {

			String nombreIngresado = JOptionPane.showInputDialog("Ingrese el nombre ");
			String profesionImngresada = JOptionPane.showInputDialog("Ingrese la profesion ");
			int telefonoIngresado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el telefono "));
			int edadIngresada = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad "));

			miDao.modificarPersona(
					new PersonaVo(idIngresado, nombreIngresado, edadIngresada, profesionImngresada, telefonoIngresado));

		}

		idIngresado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la persona a BORRAR"));

		if (miDao.buscarPersona(idIngresado) != null) {
			miDao.eliminarPersona(idIngresado);
		}

		System.out.println("Fin de la App");

	}

}
