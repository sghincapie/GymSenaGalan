package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.Conexion;
import vo.EjercicioVo;
import vo.RutinaVo;

public class RutinaDao {

	
	
	public String eliminarRutina(RutinaVo mirutina) {
		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConnection();

		String resp = "";
		String sentencia = "delete from rutina where idRutina='"+mirutina.getId()+"'";
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
	
	public ArrayList<RutinaVo> obtenerListaRutinaPecho() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		RutinaVo RutinaVo = new RutinaVo();
		ArrayList<RutinaVo> listaRutina = null;

		connection = miConexion.getConnection();

		String consulta = "select *from rutina where nombre='pecho'";

		try {
			if (connection != null) {
				listaRutina= new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				while (result.next() == true) {
					RutinaVo = new RutinaVo();
					RutinaVo.setId(result.getString("idRutina"));
					RutinaVo.setTipo(result.getString("tipo"));
					RutinaVo.setNombre(result.getString("nombre"));
					RutinaVo.setIdE1(result.getString("ide1"));
					RutinaVo.setIdE2(result.getString("ide2"));
					RutinaVo.setIdE3(result.getString("ide3"));
					RutinaVo.setIdE4(result.getString("ide4"));
					RutinaVo.setIdE5(result.getString("ide5"));
					RutinaVo.setIdE6(result.getString("ide6"));
					RutinaVo.setIdE7(result.getString("ide7"));
					RutinaVo.setIdE8(result.getString("ide8"));
					listaRutina.add(RutinaVo);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del ejercicio" + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaRutina;
	}
	
	
	public ArrayList<RutinaVo> obtenerListaRutinaEspalda() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		RutinaVo RutinaVo = new RutinaVo();
		ArrayList<RutinaVo> listaRutina = null;

		connection = miConexion.getConnection();

		String consulta = "select *from rutina where nombre='espalda'";

		try {
			if (connection != null) {
				listaRutina = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				while (result.next() == true) {
					RutinaVo = new RutinaVo();
					RutinaVo.setId(result.getString("idRutina"));
					RutinaVo.setTipo(result.getString("tipo"));
					RutinaVo.setNombre(result.getString("nombre"));
					RutinaVo.setIdE1(result.getString("ide1"));
					RutinaVo.setIdE2(result.getString("ide2"));
					RutinaVo.setIdE3(result.getString("ide3"));
					RutinaVo.setIdE4(result.getString("ide4"));
					RutinaVo.setIdE5(result.getString("ide5"));
					RutinaVo.setIdE6(result.getString("ide6"));
					RutinaVo.setIdE7(result.getString("ide7"));
					RutinaVo.setIdE8(result.getString("ide8"));
					listaRutina.add(RutinaVo);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del ejercicio" + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaRutina;
	}
	
	public ArrayList<RutinaVo> obtenerListaRutinaBiceps() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		RutinaVo RutinaVo = new RutinaVo();
		ArrayList<RutinaVo> listaRutina = null;

		connection = miConexion.getConnection();

		String consulta = "select *from rutina where nombre='biceps'";

		try {
			if (connection != null) {
				listaRutina = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				while (result.next() == true) {
					RutinaVo = new RutinaVo();
					RutinaVo.setId(result.getString("idRutina"));
					RutinaVo.setTipo(result.getString("tipo"));
					RutinaVo.setNombre(result.getString("nombre"));
					RutinaVo.setIdE1(result.getString("ide1"));
					RutinaVo.setIdE2(result.getString("ide2"));
					RutinaVo.setIdE3(result.getString("ide3"));
					RutinaVo.setIdE4(result.getString("ide4"));
					RutinaVo.setIdE5(result.getString("ide5"));
					RutinaVo.setIdE6(result.getString("ide6"));
					RutinaVo.setIdE7(result.getString("ide7"));
					RutinaVo.setIdE8(result.getString("ide8"));
					listaRutina.add(RutinaVo);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del ejercicio" + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaRutina;
	}
	
	public ArrayList<RutinaVo> obtenerListaRutinaTriceps() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		RutinaVo RutinaVo = new RutinaVo();
		ArrayList<RutinaVo> listaRutina = null;

		connection = miConexion.getConnection();

		String consulta = "select *from rutina where nombre='tripces'";

		try {
			if (connection != null) {
				listaRutina = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				while (result.next() == true) {
					RutinaVo = new RutinaVo();
					RutinaVo.setId(result.getString("idRutina"));
					RutinaVo.setTipo(result.getString("tipo"));
					RutinaVo.setNombre(result.getString("nombre"));
					RutinaVo.setIdE1(result.getString("ide1"));
					RutinaVo.setIdE2(result.getString("ide2"));
					RutinaVo.setIdE3(result.getString("ide3"));
					RutinaVo.setIdE4(result.getString("ide4"));
					RutinaVo.setIdE5(result.getString("ide5"));
					RutinaVo.setIdE6(result.getString("ide6"));
					RutinaVo.setIdE7(result.getString("ide7"));
					RutinaVo.setIdE8(result.getString("ide8"));
					listaRutina.add(RutinaVo);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del ejercicio" + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaRutina;
	}
	
	public ArrayList<RutinaVo> obtenerListaRutinaCadera() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		RutinaVo RutinaVo = new RutinaVo();
		ArrayList<RutinaVo> listaRutina = null;
		connection = miConexion.getConnection();

		String consulta = "select *from rutina where nombre='cadera'";

		try {
			if (connection != null) {
				listaRutina = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				while (result.next() == true) {
					RutinaVo = new RutinaVo();
					RutinaVo.setId(result.getString("idRutina"));
					RutinaVo.setTipo(result.getString("tipo"));
					RutinaVo.setNombre(result.getString("nombre"));
					RutinaVo.setIdE1(result.getString("ide1"));
					RutinaVo.setIdE2(result.getString("ide2"));
					RutinaVo.setIdE3(result.getString("ide3"));
					RutinaVo.setIdE4(result.getString("ide4"));
					RutinaVo.setIdE5(result.getString("ide5"));
					RutinaVo.setIdE6(result.getString("ide6"));
					RutinaVo.setIdE7(result.getString("ide7"));
					RutinaVo.setIdE8(result.getString("ide8"));
					listaRutina.add(RutinaVo);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del ejercicio" + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaRutina;
	}
	
	public ArrayList<RutinaVo> obtenerListaRutinaHombros() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		RutinaVo RutinaVo = new RutinaVo();
		ArrayList<RutinaVo> listaRutina = null;

		connection = miConexion.getConnection();

		String consulta = "select *from rutina where nombre='hombro'";

		try {
			if (connection != null) {
				listaRutina = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				while (result.next() == true) {
					RutinaVo = new RutinaVo();
					RutinaVo.setId(result.getString("idRutina"));
					RutinaVo.setTipo(result.getString("tipo"));
					RutinaVo.setNombre(result.getString("nombre"));
					RutinaVo.setIdE1(result.getString("ide1"));
					RutinaVo.setIdE2(result.getString("ide2"));
					RutinaVo.setIdE3(result.getString("ide3"));
					RutinaVo.setIdE4(result.getString("ide4"));
					RutinaVo.setIdE5(result.getString("ide5"));
					RutinaVo.setIdE6(result.getString("ide6"));
					RutinaVo.setIdE7(result.getString("ide7"));
					RutinaVo.setIdE8(result.getString("ide8"));
					listaRutina.add(RutinaVo);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del ejercicio" + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaRutina;
	}
	
	public ArrayList<RutinaVo> obtenerListaRutinaPierna() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		RutinaVo RutinaVo = new RutinaVo();
		ArrayList<RutinaVo> listaRutina = null;

		connection = miConexion.getConnection();

		String consulta = "select *from rutina where nombre='pierna'";

		try {
			if (connection != null) {
				listaRutina= new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				while (result.next() == true) {
					RutinaVo = new RutinaVo();
					RutinaVo.setId(result.getString("idRutina"));
					RutinaVo.setTipo(result.getString("tipo"));
					RutinaVo.setNombre(result.getString("nombre"));
					RutinaVo.setIdE1(result.getString("ide1"));
					RutinaVo.setIdE2(result.getString("ide2"));
					RutinaVo.setIdE3(result.getString("ide3"));
					RutinaVo.setIdE4(result.getString("ide4"));
					RutinaVo.setIdE5(result.getString("ide5"));
					RutinaVo.setIdE6(result.getString("ide6"));
					RutinaVo.setIdE7(result.getString("ide7"));
					RutinaVo.setIdE8(result.getString("ide8"));
					listaRutina.add(RutinaVo);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del ejercicio" + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaRutina;
	}
	
	public ArrayList<RutinaVo> obtenerListaRutinaMuslo() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		RutinaVo RutinaVo = new RutinaVo();
		ArrayList<RutinaVo> listaRutina = null;

		connection = miConexion.getConnection();

		String consulta = "select *from rutina where nombre='muslo'";

		try {
			if (connection != null) {
				listaRutina = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				while (result.next() == true) {
					RutinaVo = new RutinaVo();
					RutinaVo.setId(result.getString("idRutina"));
					RutinaVo.setTipo(result.getString("tipo"));
					RutinaVo.setNombre(result.getString("nombre"));
					RutinaVo.setIdE1(result.getString("ide1"));
					RutinaVo.setIdE2(result.getString("ide2"));
					RutinaVo.setIdE3(result.getString("ide3"));
					RutinaVo.setIdE4(result.getString("ide4"));
					RutinaVo.setIdE5(result.getString("ide5"));
					RutinaVo.setIdE6(result.getString("ide6"));
					RutinaVo.setIdE7(result.getString("ide7"));
					RutinaVo.setIdE8(result.getString("ide8"));
					listaRutina.add(RutinaVo);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del ejercicio" + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaRutina;
	}
	
	public ArrayList<RutinaVo> obtenerListaRutinaTrapecio() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		RutinaVo RutinaVo = new RutinaVo();
		ArrayList<RutinaVo> listaRutina = null;

		connection = miConexion.getConnection();

		String consulta = "select *from rutina where nombre='trapecio'";

		try {
			if (connection != null) {
				listaRutina = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				while (result.next() == true) {
					RutinaVo = new RutinaVo();
					RutinaVo.setId(result.getString("idRutina"));
					RutinaVo.setTipo(result.getString("tipo"));
					RutinaVo.setNombre(result.getString("nombre"));
					RutinaVo.setIdE1(result.getString("ide1"));
					RutinaVo.setIdE2(result.getString("ide2"));
					RutinaVo.setIdE3(result.getString("ide3"));
					RutinaVo.setIdE4(result.getString("ide4"));
					RutinaVo.setIdE5(result.getString("ide5"));
					RutinaVo.setIdE6(result.getString("ide6"));
					RutinaVo.setIdE7(result.getString("ide7"));
					RutinaVo.setIdE8(result.getString("ide8"));
					listaRutina.add(RutinaVo);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del ejercicio" + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaRutina;
	}
	
	public ArrayList<RutinaVo> ConsultaRutina(RutinaVo miejercicioEditar) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		RutinaVo RutinaVo = new RutinaVo();
		ArrayList<RutinaVo> listaRutina = null;

		connection = miConexion.getConnection();

		String consulta = "select *from ejercicio ";

		try {
			if (connection != null) {
				listaRutina = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				if(result.next() == true) {
					RutinaVo = new RutinaVo();
					RutinaVo.setId(result.getString("idRutina"));
					RutinaVo.setTipo(result.getString("tipo"));
					RutinaVo.setNombre(result.getString("nombre"));
					RutinaVo.setIdE1(result.getString("ide1"));
					RutinaVo.setIdE2(result.getString("ide2"));
					RutinaVo.setIdE3(result.getString("ide3"));
					RutinaVo.setIdE4(result.getString("ide4"));
					RutinaVo.setIdE5(result.getString("ide5"));
					RutinaVo.setIdE6(result.getString("ide6"));
					RutinaVo.setIdE7(result.getString("ide7"));
					RutinaVo.setIdE8(result.getString("ide8"));
					listaRutina.add(RutinaVo);
				}
				else{
					listaRutina = null;
					System.out.println("No Encontre Nada");
					miConexion.desconectar();
				}
				
				
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del ejercicio" + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaRutina;
		
	}
	public RutinaVo obtenerRutina(String idrutina) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		RutinaVo RutinaVo = new RutinaVo();
		

		connection = miConexion.getConnection();

		String consulta = "select *from rutina where idRutina='"+idrutina+"'";

		try {
			if (connection != null) {
				
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();
				if(result.next() == true) {
					RutinaVo = new RutinaVo();
					RutinaVo.setId(result.getString("idRutina"));
					RutinaVo.setTipo(result.getString("tipo"));
					RutinaVo.setNombre(result.getString("nombre"));
					RutinaVo.setIdE1(result.getString("ide1"));
					RutinaVo.setIdE2(result.getString("ide2"));
					RutinaVo.setIdE3(result.getString("ide3"));
					RutinaVo.setIdE4(result.getString("ide4"));
					RutinaVo.setIdE5(result.getString("ide5"));
					RutinaVo.setIdE6(result.getString("ide6"));
					RutinaVo.setIdE7(result.getString("ide7"));
					RutinaVo.setIdE8(result.getString("ide8"));
					
				}
				else{
					System.out.println("No Encontre Nada");
					miConexion.desconectar();
				}
				
				
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del ejercicio" + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return RutinaVo;
		
	}

	public String editarRutina(RutinaVo rutina) {
		String resultado = "";

		Connection connection = null;
		Conexion conexion = new Conexion();
		connection = conexion.getConnection();

		try {
			String consulta = "update ejercicio set nombre=?, tipo=?, ide1=?, ide2=?, ide3=?,"
					+ "ide4=?, ide5=?, ide6=?, ide7=?,ide8=? where id='"+rutina.getId()+"'";

			PreparedStatement preparedStatement = connection.prepareStatement(consulta);

			preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setString(1, rutina.getNombre());
			preparedStatement.setString(2, rutina.getTipo());
			preparedStatement.setString(3, rutina.getIdE1());
			preparedStatement.setString(4, rutina.getIdE2());
			preparedStatement.setString(5, rutina.getIdE3());
			preparedStatement.setString(6, rutina.getIdE4());
			preparedStatement.setString(6, rutina.getIdE5());
			preparedStatement.setString(6, rutina.getIdE6());
			preparedStatement.setString(6, rutina.getIdE7());
			preparedStatement.setString(6, rutina.getIdE8());
					
			preparedStatement.executeUpdate();

			resultado = "se ha actualizado el ejercicio satisfactoriamente";

			conexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e);
			resultado = "no se pudo actualizar el ejercicio";
		}
		return resultado;
	}
	
	
	
	
}
