package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.Conexion;
import vo.UsuarioVo;
import vo.MedidasUsuarioVo;


public class PersonaDao {

	

	public String agregarPersona(UsuarioVo miusuario) {
		String resultado = "";

		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preparedStatement = null;
		PreparedStatement statement = null;

		ResultSet result = null;

		connection = conexion.getConnection();
		String consulta1 = "SELECT *from registrados where documento=" + miusuario.getDocumento() + "";

		try {
			if (connection != null) {
				statement = connection.prepareStatement(consulta1);
				result = statement.executeQuery();
				if (result.next()) {

					resultado = "Ya esta registrado";
					System.out.println("Ya esta registrado");
				} else {

					connection = conexion.getConnection();
					String consulta = "insert into registrados (`documento`, `Nombre`, `Apellido`, `Ficha`, `sexo`, `telefono`, `correo`, `formacion`,`idRutina`) "
							+ "values(?,?,?,?,?,?,?,?,?)";

					try {
						preparedStatement = connection.prepareStatement(consulta);
						preparedStatement.setString(1, miusuario.getDocumento());
						preparedStatement.setString(2, miusuario.getNombre());
						preparedStatement.setString(3, miusuario.getApellido());
						preparedStatement.setString(4, miusuario.getFicha());
						preparedStatement.setString(5, miusuario.getSexo());
						preparedStatement.setString(6, miusuario.getTelefono());
						preparedStatement.setString(7, miusuario.getCorreo());
						preparedStatement.setString(8, miusuario.getFormacion());
						preparedStatement.setString(9, miusuario.getRutina());
						preparedStatement.execute();

						resultado = "registro exitoso";

					} catch (SQLException e) {
						System.out.println("No se pudo registrar el dato: " + e.getMessage());
						resultado = "error";

					}
					conexion.desconectar();
				}
				conexion.desconectar();

			}
		} catch (SQLException e) {

			System.out.println("Error en la consulta del usuario : " + e.getMessage());

		}

		return resultado;

	}

	public ArrayList<UsuarioVo> obtenerListaPersonas() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		UsuarioVo miUsuarioVo = new UsuarioVo();
		ArrayList<UsuarioVo> listaPersonas = null;

		connection = miConexion.getConnection();

		String consulta = "select *from ingresogim,registrados where ingresogim.documento=registrados.documento";

		try {
			if (connection != null) {
				listaPersonas = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				while (result.next() == true) {
					miUsuarioVo = new UsuarioVo();
					miUsuarioVo.setDocumento(result.getString("documento"));
					miUsuarioVo.setNombre(result.getString("nombre"));
					miUsuarioVo.setApellido(result.getString("apellido"));
					miUsuarioVo.setFicha(result.getString("ficha"));
					miUsuarioVo.setTelefono(result.getString("telefono"));
					miUsuarioVo.setCorreo(result.getString("Correo"));
					miUsuarioVo.setRutina(result.getString("idRutina"));
					miUsuarioVo.setFormacion(result.getString("formacion"));
					miUsuarioVo.setSexo(result.getString("sexo"));
					miUsuarioVo.setIdingreso(result.getString("ID"));
					miUsuarioVo.setHoraIngreso(result.getString("fecha"));
					listaPersonas.add(miUsuarioVo);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del usuario" + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaPersonas;
	}
	public ArrayList<UsuarioVo> obtenerListaPersonasRegistrados() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		UsuarioVo miUsuarioVo = new UsuarioVo();
		ArrayList<UsuarioVo> listaPersonas2 = null;

		connection = miConexion.getConnection();

		String consulta = "select *from registrados where estado='Activo'";

		try {
			if (connection != null) {
				listaPersonas2 = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				while (result.next() == true) {
					miUsuarioVo = new UsuarioVo();
					miUsuarioVo.setDocumento(result.getString("documento"));
					miUsuarioVo.setNombre(result.getString("nombre"));
					miUsuarioVo.setApellido(result.getString("apellido"));
					miUsuarioVo.setFicha(result.getString("ficha"));
					miUsuarioVo.setTelefono(result.getString("telefono"));
					miUsuarioVo.setCorreo(result.getString("Correo"));
					miUsuarioVo.setRutina(result.getString("idRutina"));
					miUsuarioVo.setFormacion(result.getString("formacion"));
					miUsuarioVo.setEstado(result.getString("estado"));
					miUsuarioVo.setSexo(result.getString("sexo"));
					listaPersonas2.add(miUsuarioVo);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del usuario" + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaPersonas2;
	}


	public String editarPersona(UsuarioVo UsuarioVo) {
		String resultado = "";

		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConnection();

		try {
			String consulta = "update registrados set nombre=?, apellido=?, ficha=?, telefono=?, correo=?,"
					+ "formacion=?, sexo=? where documento="+UsuarioVo.getDocumento();

			PreparedStatement preparedStatement = connection.prepareStatement(consulta);

			preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setString(1, UsuarioVo.getNombre());
			preparedStatement.setString(2, UsuarioVo.getApellido());
			preparedStatement.setString(3, UsuarioVo.getFicha());
			preparedStatement.setString(4, UsuarioVo.getTelefono());
			preparedStatement.setString(5, UsuarioVo.getCorreo());
			preparedStatement.setString(6, UsuarioVo.getFormacion());
			preparedStatement.setString(7, UsuarioVo.getSexo());			
			preparedStatement.executeUpdate();

			resultado = "se ha actualizado la persona satisfactoriamente";

			conexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e);
			resultado = "no se pudo actualizar la persona";
		}
		return resultado;
	}
	
	
	public String agregarMedidasUsuarios(MedidasUsuarioVo MedidasUsuarioVo) {
		String resultado = "";

		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preparedStatement = null;
		

	    connection = conexion.getConnection();
		String consulta = "insert into medidasusuarios (`documento`,`peso`,`estatura`,`cuello`,`pecho`,`antebrazo`,`brazo`,`cintura`,`caderas`,`muslo`,`pantorrilla`) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?)";

					try {
						preparedStatement = connection.prepareStatement(consulta);
						preparedStatement.setString(1, MedidasUsuarioVo.getDocumento());
						preparedStatement.setString(2, MedidasUsuarioVo.getPeso()+"");
						preparedStatement.setString(3, MedidasUsuarioVo.getEstatura());
						preparedStatement.setString(4, MedidasUsuarioVo.getCuello());
						preparedStatement.setString(5, MedidasUsuarioVo.getPecho());
						preparedStatement.setString(6, MedidasUsuarioVo.getAntebrazo());
						preparedStatement.setString(7, MedidasUsuarioVo.getBrazo());
						preparedStatement.setString(8, MedidasUsuarioVo.getCintura());
						preparedStatement.setString(9,MedidasUsuarioVo.getCaderas());
						preparedStatement.setString(10,MedidasUsuarioVo.getMuslo());
						preparedStatement.setString(11,MedidasUsuarioVo.getPantorrilla());
						preparedStatement.execute();

						resultado = "registro exitoso";

					} catch (SQLException e) {
						System.out.println("No se pudo registrar el dato: " + e.getMessage());
						resultado = "error";

					}
					conexion.desconectar();
				
		return resultado;

	}

	public String eliminarPersona(UsuarioVo UsuarioVo) {
		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConnection();

		String resp = "";
		String sentencia = "update registrados set estado='Inactivo' where documento="+UsuarioVo.getDocumento();
		try {
			

			PreparedStatement statement = connection.prepareStatement(sentencia);
			statement.executeUpdate();
            System.out.println("Se ha incativado exitosamente");
			resp = "Se ha inactivado exitosamente";
			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			resp = "no se pudo inactivado";
		}
		return resp;

	}

	public UsuarioVo consultarPersonaIndividual(String documento) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		UsuarioVo miUsuario = null;

		connection = miConexion.getConnection();
		String consulta = "select * from registrados where documento=" + documento;

		try {
			if (connection != null) {
				statement = connection.prepareStatement(consulta);
				result = statement.executeQuery();

				if (result.next() == true) {
					miUsuario = new UsuarioVo();
					miUsuario.setDocumento(result.getString("documento"));
					miUsuario.setNombre(result.getString("nombre"));
					miUsuario.setApellido(result.getString("apellido"));
					miUsuario.setFicha(result.getString("ficha"));
					miUsuario.setTelefono(result.getString("telefono"));
					miUsuario.setCorreo(result.getString("correo"));
					miUsuario.setSexo(result.getString("sexo"));
					miUsuario.setFormacion(result.getString("formacion"));
					miUsuario.setRutina(result.getString("idRutina"));
					
				}
			}

		} catch (SQLException e) {
			System.out.println("Error en la consulta del usuario" + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return miUsuario;
	}

	

	public String AgregarIngreso(String documento) {
		String resultado = "";

		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preparedStatement = null;
		PreparedStatement statement = null;

		ResultSet result = null;

		connection = conexion.getConnection();
		String consulta1 = "SELECT *from registrados where documento=" + documento + "";
		
		try {
			 if (connection != null) {
				statement = connection.prepareStatement(consulta1);
				result = statement.executeQuery();
				
				if (result.next()) {

					connection = conexion.getConnection();
					String consulta2 = "SELECT *from IngresoGim where documento=" + documento + "";
					
					if (connection != null) {
						statement = connection.prepareStatement(consulta2);
						result = statement.executeQuery();
						if (result.next()) {
							resultado = "ya hay un registro hoy de este usuario";
							System.out.println("ya hay un registro hoy de este usuario");
						}else {
							connection = conexion.getConnection();
							String consulta = "insert into IngresoGim (`documento`) values(?)";
							
							try {
								preparedStatement = connection.prepareStatement(consulta);
								preparedStatement.setString(1, documento);
								preparedStatement.execute();

								resultado = "registro exitoso disfrute del gimnasio";
								System.out.println("registro exitoso disfrute del gimnasio");
							} catch (SQLException e) {
								System.out.println("No se pudo registrar el ingreso: " + e.getMessage());
								resultado = "No se pudo registrar el ingreso";

							}
							conexion.desconectar();

						}
					}else {
						resultado="la connecion ingreso gim es nula";
					}
				}else {
					resultado="el usuario no pertenece al gimnasio";
				}
			 }else {
				 resultado="la connecion registrados es nula"; 
			 }
			
			
		}catch (SQLException e) {

			resultado="Error no es un usuario del Gimnasio: " + e.getMessage();

		}

		return resultado;
		
		
}
	
	public ArrayList<UsuarioVo> obtenerListaPersonasRegistradosInactivos() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		UsuarioVo miUsuarioVo = new UsuarioVo();
		ArrayList<UsuarioVo> listaPersonas2 = null;

		connection = miConexion.getConnection();

		String consulta = "select *from registrados where estado='Inactivo'";

		try {
			if (connection != null) {
				listaPersonas2 = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				while (result.next() == true) {
					miUsuarioVo = new UsuarioVo();
					miUsuarioVo.setDocumento(result.getString("documento"));
					miUsuarioVo.setNombre(result.getString("nombre"));
					miUsuarioVo.setApellido(result.getString("apellido"));
					miUsuarioVo.setFicha(result.getString("ficha"));
					miUsuarioVo.setTelefono(result.getString("telefono"));
					miUsuarioVo.setCorreo(result.getString("Correo"));
					miUsuarioVo.setRutina(result.getString("idRutina"));
					miUsuarioVo.setFormacion(result.getString("formacion"));
					miUsuarioVo.setEstado(result.getString("estado"));
					miUsuarioVo.setSexo(result.getString("sexo"));
					listaPersonas2.add(miUsuarioVo);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del usuario" + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaPersonas2;
	}
	
	public String ActivarPersona(UsuarioVo UsuarioVo) {
		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConnection();

		String resp = "";
		String sentencia = "update registrados set estado='activo' where documento="+UsuarioVo.getDocumento();
		try {
			

			PreparedStatement statement = connection.prepareStatement(sentencia);
			statement.executeUpdate();
            System.out.println("Se ha ativado exitosamente");
			resp = "Se ha inactivado exitosamente";
			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			resp = "no se pudo inactivado";
		}
		return resp;

	}

}
