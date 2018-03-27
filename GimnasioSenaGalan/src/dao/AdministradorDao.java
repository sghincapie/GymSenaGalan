package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexion.Conexion;
import vo.AdministradorVo;

public class AdministradorDao {
    AdministradorVo miadminvo;
	boolean si = false;
	
	

	public AdministradorVo getMiadminvo() {
		return miadminvo;
	}

	public void setMiadminvo(AdministradorVo miadminvo) {
		this.miadminvo = miadminvo;
	}

	public boolean isSi() {
		return si;
	}

	public void setSi(boolean si) {
		this.si = si;
	} 
	
	public AdministradorVo ValidarUsuario(String documento, String contrase�a) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;
		
        miadminvo=new AdministradorVo();
		connection = miConexion.getConnection();

		String consulta = "select * from admin where Usuario='" + documento + "' and contrase�a='" + contrase�a + "'";
		;

		try {
			if (connection != null) {
				statement = connection.prepareStatement(consulta);
				result = statement.executeQuery();

				if (result.next() == true) {
					miadminvo.setDocumento(result.getString("usuario"));
					miadminvo.setContrase�a(result.getString("contrase�a"));
					si = true;
					System.out.print(" 2.2 encontro algo");

				} else {
					
					si = false;
					System.out.print(" 2.3 no encontro nada");
				}
			}

		} catch (SQLException e) {
			System.out.println("Error en la consulta del usuario" + e.getMessage());
			
			si = false;
		} finally {
			miConexion.desconectar();
		}
		System.out.print(" 3 retorna");
		return miadminvo;
	}
}
