package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.Conexion;
import vo.EjercicioVo;




public class EjercicioDao {

	public String agregarEjercicio(EjercicioVo miejercicio) {
		String resultado = "";

		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preparedStatement = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		connection = conexion.getConnection();
		String consulta1 = "select *from ejercicio where id='"+miejercicio.getIdEjercicio()+"'";
		
		try {
			if (connection !=null) {
				statement = connection.prepareStatement(consulta1);
				result = statement.executeQuery();
			
				if (result.next()) {
				 resultado="Ya hay un Ejercicio Registrado Con este ID";
				 System.out.println("Ya hay un Ejercicio Registrado Con este ID");
				}else {
				
					connection = conexion.getConnection();
					String consulta = "insert into ejercicio (`id`,`tipoejercicio`, `Nombre`, `series`, `repeticiones`, `nivel`, `descripcion`, `imagen`) "
							+ "values(?,?,?,?,?,?,?,?)";

					try {
						preparedStatement = connection.prepareStatement(consulta);
						preparedStatement.setString(1, miejercicio.getIdEjercicio());
						preparedStatement.setString(2, miejercicio.getTipoEjercicio());
						preparedStatement.setString(3, miejercicio.getNombre());
						preparedStatement.setString(4, miejercicio.getSeries());
						preparedStatement.setString(5, miejercicio.getRepeticiones());
						preparedStatement.setString(6, miejercicio.getNivel());
						preparedStatement.setString(7, miejercicio.getDescripcion());
						preparedStatement.setString(8, miejercicio.getImagen());
						preparedStatement.execute();

						resultado = "registro exitoso";
                        System.out.println("registro exitoso");
					} catch (SQLException e) {
						System.out.println("No se pudo registrar el ejercicio: " + e.getMessage());
						resultado = "error";

					}
					conexion.desconectar();
				

		           

				}
				conexion.desconectar();
				
			}else {
				resultado="No se pudo conectar al mysql";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		

		 return resultado;			
	}
	public String editarEjercicio(EjercicioVo EjercicioVo) {
		String resultado = "";

		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConnection();

		try {
			String consulta = "update ejercicio set nombre=?, descripcion=?, nivel=?, repeticiones=?, series=?,"
					+ "tipoEjercicio=? where id='"+EjercicioVo.getIdEjercicio()+"'";

			PreparedStatement preparedStatement = connection.prepareStatement(consulta);

			preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setString(1, EjercicioVo.getNombre());
			preparedStatement.setString(2, EjercicioVo.getDescripcion());
			preparedStatement.setString(3, EjercicioVo.getNivel());
			preparedStatement.setString(4, EjercicioVo.getRepeticiones());
			preparedStatement.setString(5, EjercicioVo.getSeries());
			preparedStatement.setString(6, EjercicioVo.getTipoEjercicio());
					
			preparedStatement.executeUpdate();

			resultado = "se ha actualizado el ejercicio satisfactoriamente";

			conexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e);
			resultado = "no se pudo actualizar el ejercicio";
		}
		return resultado;
	}
	
	public String eliminarEjercicio(EjercicioVo miejercicio) {
		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConnection();

		String resp = "";
		String sentencia = "delete from ejercicio where id='"+miejercicio.getIdEjercicio()+"'";
		try {
			

			PreparedStatement statement = connection.prepareStatement(sentencia);
			statement.executeUpdate();
            System.out.println("Se ha Eliminado exitosamente");
			resp = "Se ha inactivado exitosamente";
			statement.close();
			conexion.desconectar();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			resp = "no se pudo Eliminar";
		}
		return resp;

	}
	
	
	public ArrayList<EjercicioVo> obtenerListaEjerciciosPecho() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		EjercicioVo EjercicioVo = new EjercicioVo();
		ArrayList<EjercicioVo> listaEjercicios = null;

		connection = miConexion.getConnection();

		String consulta = "select *from ejercicio where tipoEjercicio='pecho'";

		try {
			if (connection != null) {
				listaEjercicios = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				while (result.next() == true) {
					EjercicioVo = new EjercicioVo();
					EjercicioVo.setIdEjercicio(result.getString("id"));
					EjercicioVo.setTipoEjercicio(result.getString("tipoEjercicio"));
					EjercicioVo.setNombre(result.getString("nombre"));
					EjercicioVo.setNivel(result.getString("nivel"));
					EjercicioVo.setSeries(result.getString("series"));
					EjercicioVo.setRepeticiones(result.getString("repeticiones"));
					EjercicioVo.setDescripcion(result.getString("descripcion"));
					listaEjercicios.add(EjercicioVo);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del ejercicio" + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaEjercicios;
	}
	
	public EjercicioVo obtenerListaEjercicios2(String idEjercicio) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		EjercicioVo EjercicioVo = new EjercicioVo();
		

		connection = miConexion.getConnection();

		String consulta = "select *from ejercicio where id='"+idEjercicio+"'";

		try {
			if (connection != null) {
				
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				while (result.next() == true) {
					EjercicioVo = new EjercicioVo();
					EjercicioVo.setIdEjercicio(result.getString("id"));
					EjercicioVo.setTipoEjercicio(result.getString("tipoEjercicio"));
					EjercicioVo.setNombre(result.getString("nombre"));
					EjercicioVo.setNivel(result.getString("nivel"));
					EjercicioVo.setSeries(result.getString("series"));
					EjercicioVo.setRepeticiones(result.getString("repeticiones"));
					EjercicioVo.setDescripcion(result.getString("descripcion"));
					
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del usuario" + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return EjercicioVo;
	}
	public ArrayList<EjercicioVo> obtenerListaEjerciciosEspalda() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		EjercicioVo EjercicioVo = new EjercicioVo();
		ArrayList<EjercicioVo> listaEjercicios = null;

		connection = miConexion.getConnection();

		String consulta = "select *from ejercicio where tipoEjercicio='espalda'";

		try {
			if (connection != null) {
				listaEjercicios = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				while (result.next() == true) {
					EjercicioVo = new EjercicioVo();
					EjercicioVo.setIdEjercicio(result.getString("id"));
					EjercicioVo.setTipoEjercicio(result.getString("tipoEjercicio"));
					EjercicioVo.setNombre(result.getString("nombre"));
					EjercicioVo.setNivel(result.getString("nivel"));
					EjercicioVo.setSeries(result.getString("series"));
					EjercicioVo.setRepeticiones(result.getString("repeticiones"));
					EjercicioVo.setDescripcion(result.getString("descripcion"));
					listaEjercicios.add(EjercicioVo);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del ejercicio" + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaEjercicios;
	}
	
	public ArrayList<EjercicioVo> obtenerListaEjerciciosBiceps() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		EjercicioVo EjercicioVo = new EjercicioVo();
		ArrayList<EjercicioVo> listaEjercicios = null;

		connection = miConexion.getConnection();

		String consulta = "select *from ejercicio where tipoEjercicio='biceps'";

		try {
			if (connection != null) {
				listaEjercicios = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				while (result.next() == true) {
					EjercicioVo = new EjercicioVo();
					EjercicioVo.setIdEjercicio(result.getString("id"));
					EjercicioVo.setTipoEjercicio(result.getString("tipoEjercicio"));
					EjercicioVo.setNombre(result.getString("nombre"));
					EjercicioVo.setNivel(result.getString("nivel"));
					EjercicioVo.setSeries(result.getString("series"));
					EjercicioVo.setRepeticiones(result.getString("repeticiones"));
					EjercicioVo.setDescripcion(result.getString("descripcion"));
					listaEjercicios.add(EjercicioVo);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del ejercicio" + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaEjercicios;
	}
	
	public ArrayList<EjercicioVo> obtenerListaEjerciciosTriceps() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		EjercicioVo EjercicioVo = new EjercicioVo();
		ArrayList<EjercicioVo> listaEjercicios = null;

		connection = miConexion.getConnection();

		String consulta = "select *from ejercicio where tipoEjercicio='tripces'";

		try {
			if (connection != null) {
				listaEjercicios = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				while (result.next() == true) {
					EjercicioVo = new EjercicioVo();
					EjercicioVo.setIdEjercicio(result.getString("id"));
					EjercicioVo.setTipoEjercicio(result.getString("tipoEjercicio"));
					EjercicioVo.setNombre(result.getString("nombre"));
					EjercicioVo.setNivel(result.getString("nivel"));
					EjercicioVo.setSeries(result.getString("series"));
					EjercicioVo.setRepeticiones(result.getString("repeticiones"));
					EjercicioVo.setDescripcion(result.getString("descripcion"));
					listaEjercicios.add(EjercicioVo);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del ejercicio" + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaEjercicios;
	}
	
	public ArrayList<EjercicioVo> obtenerListaEjerciciosCadera() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		EjercicioVo EjercicioVo = new EjercicioVo();
		ArrayList<EjercicioVo> listaEjercicios = null;

		connection = miConexion.getConnection();

		String consulta = "select *from ejercicio where tipoEjercicio='cadera'";

		try {
			if (connection != null) {
				listaEjercicios = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				while (result.next() == true) {
					EjercicioVo = new EjercicioVo();
					EjercicioVo.setIdEjercicio(result.getString("id"));
					EjercicioVo.setTipoEjercicio(result.getString("tipoEjercicio"));
					EjercicioVo.setNombre(result.getString("nombre"));
					EjercicioVo.setNivel(result.getString("nivel"));
					EjercicioVo.setSeries(result.getString("series"));
					EjercicioVo.setRepeticiones(result.getString("repeticiones"));
					EjercicioVo.setDescripcion(result.getString("descripcion"));
					listaEjercicios.add(EjercicioVo);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del ejercicio" + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaEjercicios;
	}
	
	public ArrayList<EjercicioVo> obtenerListaEjerciciosHombros() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		EjercicioVo EjercicioVo = new EjercicioVo();
		ArrayList<EjercicioVo> listaEjercicios = null;

		connection = miConexion.getConnection();

		String consulta = "select *from ejercicio where tipoEjercicio='hombro'";

		try {
			if (connection != null) {
				listaEjercicios = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				while (result.next() == true) {
					EjercicioVo = new EjercicioVo();
					EjercicioVo.setIdEjercicio(result.getString("id"));
					EjercicioVo.setTipoEjercicio(result.getString("tipoEjercicio"));
					EjercicioVo.setNombre(result.getString("nombre"));
					EjercicioVo.setNivel(result.getString("nivel"));
					EjercicioVo.setSeries(result.getString("series"));
					EjercicioVo.setRepeticiones(result.getString("repeticiones"));
					EjercicioVo.setDescripcion(result.getString("descripcion"));
					listaEjercicios.add(EjercicioVo);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del ejercicio" + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaEjercicios;
	}
	
	public ArrayList<EjercicioVo> obtenerListaEjerciciosPierna() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		EjercicioVo EjercicioVo = new EjercicioVo();
		ArrayList<EjercicioVo> listaEjercicios = null;

		connection = miConexion.getConnection();

		String consulta = "select *from ejercicio where tipoEjercicio='pierna'";

		try {
			if (connection != null) {
				listaEjercicios = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				while (result.next() == true) {
					EjercicioVo = new EjercicioVo();
					EjercicioVo.setIdEjercicio(result.getString("id"));
					EjercicioVo.setTipoEjercicio(result.getString("tipoEjercicio"));
					EjercicioVo.setNombre(result.getString("nombre"));
					EjercicioVo.setNivel(result.getString("nivel"));
					EjercicioVo.setSeries(result.getString("series"));
					EjercicioVo.setRepeticiones(result.getString("repeticiones"));
					EjercicioVo.setDescripcion(result.getString("descripcion"));
					listaEjercicios.add(EjercicioVo);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del ejercicio" + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaEjercicios;
	}
	
	public ArrayList<EjercicioVo> obtenerListaEjerciciosMuslo() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		EjercicioVo EjercicioVo = new EjercicioVo();
		ArrayList<EjercicioVo> listaEjercicios = null;

		connection = miConexion.getConnection();

		String consulta = "select *from ejercicio where tipoEjercicio='muslo'";

		try {
			if (connection != null) {
				listaEjercicios = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				while (result.next() == true) {
					EjercicioVo = new EjercicioVo();
					EjercicioVo.setIdEjercicio(result.getString("id"));
					EjercicioVo.setTipoEjercicio(result.getString("tipoEjercicio"));
					EjercicioVo.setNombre(result.getString("nombre"));
					EjercicioVo.setNivel(result.getString("nivel"));
					EjercicioVo.setSeries(result.getString("series"));
					EjercicioVo.setRepeticiones(result.getString("repeticiones"));
					EjercicioVo.setDescripcion(result.getString("descripcion"));
					listaEjercicios.add(EjercicioVo);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del ejercicio" + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaEjercicios;
	}
	
	public ArrayList<EjercicioVo> obtenerListaEjerciciosTrapecio() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		EjercicioVo EjercicioVo = new EjercicioVo();
		ArrayList<EjercicioVo> listaEjercicios = null;

		connection = miConexion.getConnection();

		String consulta = "select *from ejercicio where tipoEjercicio='trapecio'";

		try {
			if (connection != null) {
				listaEjercicios = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				while (result.next() == true) {
					EjercicioVo = new EjercicioVo();
					EjercicioVo.setIdEjercicio(result.getString("id"));
					EjercicioVo.setTipoEjercicio(result.getString("tipoEjercicio"));
					EjercicioVo.setNombre(result.getString("nombre"));
					EjercicioVo.setNivel(result.getString("nivel"));
					EjercicioVo.setSeries(result.getString("series"));
					EjercicioVo.setRepeticiones(result.getString("repeticiones"));
					EjercicioVo.setDescripcion(result.getString("descripcion"));
					listaEjercicios.add(EjercicioVo);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del ejercicio" + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaEjercicios;
	}
	
	public ArrayList<EjercicioVo> ConsultaEjercicio(EjercicioVo miejercicioEditar) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		EjercicioVo EjercicioVo = new EjercicioVo();
		ArrayList<EjercicioVo> listaEjercicios = null;

		connection = miConexion.getConnection();

		String consulta = "select *from ejercicio where tipoEjercicio='"+miejercicioEditar.getTipoEjercicio()+"' and id='"+miejercicioEditar.getIdEjercicio()+"'"
				+ " and nivel='"+miejercicioEditar.getNivel()+"'";

		try {
			if (connection != null) {
				listaEjercicios = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				if(result.next() == true) {
					EjercicioVo = new EjercicioVo();
					EjercicioVo.setIdEjercicio(result.getString("id"));
					EjercicioVo.setTipoEjercicio(result.getString("tipoEjercicio"));
					EjercicioVo.setNombre(result.getString("nombre"));
					EjercicioVo.setNivel(result.getString("nivel"));
					EjercicioVo.setSeries(result.getString("series"));
					EjercicioVo.setRepeticiones(result.getString("repeticiones"));
					EjercicioVo.setDescripcion(result.getString("descripcion"));
					listaEjercicios.add(EjercicioVo);
					System.out.println("Encontre un ejercicio");
				}
				else{
					listaEjercicios = null;
					System.out.println("No Encontre Nada");
					miConexion.desconectar();
				}
				
				
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del ejercicio" + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaEjercicios;
		
	}
	public ArrayList<EjercicioVo> obtenerListaEjercicios(String nivel) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		EjercicioVo EjercicioVo = new EjercicioVo();
		ArrayList<EjercicioVo> listaEjercicios = null;

		connection = miConexion.getConnection();

		String consulta = "select *from ejercicio where nivel='"+nivel+"'";

		try {
			if (connection != null) {
				listaEjercicios = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				while (result.next() == true) {
					EjercicioVo = new EjercicioVo();
					EjercicioVo.setIdEjercicio(result.getString("id"));
					EjercicioVo.setTipoEjercicio(result.getString("tipoEjercicio"));
					EjercicioVo.setNombre(result.getString("nombre"));
					EjercicioVo.setNivel(result.getString("nivel"));
					EjercicioVo.setSeries(result.getString("series"));
					EjercicioVo.setRepeticiones(result.getString("repeticiones"));
					EjercicioVo.setDescripcion(result.getString("descripcion"));
					listaEjercicios.add(EjercicioVo);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del ejercicio" + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaEjercicios;
	}
	
	
}
